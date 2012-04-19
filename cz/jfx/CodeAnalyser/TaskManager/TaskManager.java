package cz.jfx.CodeAnalyser.TaskManager;

import cz.jfx.CodeAnalyser.TaskManager.Listeners.JobListener;
import cz.jfx.CodeAnalyser.Control.AnalyserController;
import cz.jfx.CodeAnalyser.TaskManager.Listeners.FileListener;
import cz.jfx.CodeAnalyser.TaskManager.Listeners.FolderListener;
import cz.jfx.CodeAnalyser.TaskManager.Runners.Loader;
import cz.jfx.CodeAnalyser.TaskManager.Runners.Reader;
import cz.jfx.CodeAnalyser.TaskManager.Runners.Runner;
import java.io.File;
import java.util.ArrayList;
import javax.swing.event.EventListenerList;

/**
 *
 * @author Felix
 */
public class TaskManager {

    private ArrayList<Runner> loaders;
    private ArrayList<Runner> readers;
    private EventListenerList listenerList = new EventListenerList();
    private Finalizer finalizer;
    private AnalyserController controller;
    private boolean loadingComplete = false;
    private boolean readingComplete = false;

    public TaskManager() {
        clean();
    }

    public void addLoaders(int i) {
        for (int j = 0; j < i; j++) {
            addLoader();
        }
    }

    public void addLoader() {
        Runner r = new Loader("Loader" + loaders.size(), this);
        r.setFilter(getController().getCodeFilter());
        loaders.add(r);
    }

    public void addReaders(int i) {
        for (int j = 0; j < i; j++) {
            addLoader();
        }
    }

    public void addReader() {
        readers.add(new Reader("Reader" + readers.size(), this));
    }

    public AnalyserController getController() {
        if (controller == null) {
            controller = AnalyserController.getInstance();
        }
        return controller;
    }

    public void setController(AnalyserController controller) {
        this.controller = controller;
    }

    /**
     * FolderStorage
     */
    public synchronized File nextFolder() {
        return getController().getFolderStorage().poll();
    }

    public synchronized void addFolder(File f) {
        getController().getFolderStorage().push(f);
        invokeLoaders();
        fireFolderAdded();
    }

    public synchronized boolean isFolderStorageEmpty() {
        return getController().getFolderStorage().isEmpty();
    }

    /**
     * FileStorage
     */
    public synchronized File nextFile(File f) {
        return getController().getFileStorage().poll();
    }

    public synchronized void addFile(File f) {
        getController().getFileStorage().push(f);
        fireFileAdded();
    }

    public synchronized boolean isFileStorageEmpty() {
        return getController().getFileStorage().isEmpty();
    }

    /*
     * TaskManager function
     */
    public void start() {

        System.out.println("Spousti finalizer");
        finalizer.start();

        System.out.println("Spoustim vlakna");

        // spusteni nacitacich vlaken
        for (Runner loader : loaders) {
            loader.start();
        }

        // spusteni ctecich vlaken
        for (Runner reader : readers) {
            reader.start();
        }

        try {
            finalizer.join();
        } catch (InterruptedException ex) {
            System.out.println("**** PRERUSENO CEKANI NA FINALIZER ****");
        }
    }

    public void addFileListener(FileListener l) {
        listenerList.add(FileListener.class, l);
    }

    public void addFolderListener(FolderListener l) {
        listenerList.add(FolderListener.class, l);
    }

    public void addJobListener(JobListener l) {
        listenerList.add(JobListener.class, l);
    }

    private synchronized void setThreadsInactive(ArrayList<Runner> runners) {
        for (Runner runner : runners) {
            runner.interrupt();
        }
    }

    private void invokeThreads(ArrayList<Runner> runners) {
        System.out.println("OZIVUJI VLAKNA");
        for (Runner runner : runners) {
            if (runner.getStatus() == Runner.WAITING) {
                // invoke only one waiting thread..
                synchronized (runner) {
                    System.out.println("Notify()" + runner.getName());
                    runner.setRunning(true);
                    runner.notify();
                }
                break;
            }
        }
    }

    private void complete() {
        finalizer.setComplete(true);
        finalizer.interrupt();
        fireJobComlete();
    }

    public void clean() {
        loaders = new ArrayList<>();
        readers = new ArrayList<>();
        finalizer = new Finalizer();
    }

    /*
     * Loaders functions
     */
    private void invokeLoaders() {
        invokeThreads(loaders);
    }

    private boolean isLoadingComplete() {
        return loadingComplete;
    }

    public void checkLoadingProcess() {
        if (isFolderStorageEmpty()) {
            for (Runner runner : loaders) {
                if (runner.getStatus() == Runner.RUNNING) {
                    System.out.println(runner.getName() + "stale beziii");
                    loadingComplete = false;
                    return;
                }
            }
            loadingComplete = true;
            setThreadsInactive(loaders);
            complete();
        }
    }

    /**
     *  Listeners perfomance
     */
    private void fireJobComlete() {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i += 2) {
            ((JobListener) listeners[i + 1]).complete();
        }
    }

    private void fireFileAdded() {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == FileListener.class) {
                ((FileListener) listeners[i + 1]).added(getController().getFileStorage().size());
            }
        }
    }

    private void fireFolderAdded() {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == FolderListener.class) {
                ((FileListener) listeners[i + 1]).added(getController().getFolderStorage().size());
            }
        }
    }
}
