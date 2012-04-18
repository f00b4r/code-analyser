package cz.jfx.CodeAnalyser.TaskManager;

import cz.jfx.CodeAnalyser.Control.AnalyserController;
import cz.jfx.CodeAnalyser.TaskManager.Runners.Loader;
import cz.jfx.CodeAnalyser.TaskManager.Runners.Reader;
import cz.jfx.CodeAnalyser.TaskManager.Runners.Runner;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Felix
 */
public class TaskManager {

    private ArrayList<Runner> runners = new ArrayList<>();
    private Finalizer finalizer = new Finalizer();
    private AnalyserController controller = AnalyserController.getInstance();
    private boolean loadingComplete = false;
    private boolean readingComplete = false;

    public void addLoader() {
        runners.add(new Loader("Browser" + runners.size(), this));
    }

    public void addReader() {
        runners.add(new Reader("Reader" + runners.size(), this));
    }

    public ArrayList<Runner> getRunners() {
        return runners;
    }

    /**
     * FolderStorage
     */
    public synchronized File nextFolder() {
        return controller.getFolderStorage().poll();
    }

    public synchronized void addFolder(File f) {
        controller.getFolderStorage().push(f);
        invokeLoaders();
    }

    public synchronized boolean isFolderStorageEmpty() {
        return controller.getFolderStorage().isEmpty();
    }

    /**
     * FileStorage
     */
    public synchronized void nextFile() {
    }

    public synchronized void addFile(File f) {
        controller.getFileStorage().push(f);
    }

    public synchronized boolean isFileStorageEmpty() {
        return controller.getFileStorage().isEmpty();
    }

    /*
     * Start
     */
    public void start() {

        System.out.println("Spousti finalizer");
        finalizer.start();

        System.out.println("Spoustim vlakna");
        // spusteni vsech vlaken
        for (Runner runner : runners) {
            runner.start();
        }
        try {
            finalizer.join();
        } catch (InterruptedException ex) {
            System.out.println("**** PRERUSENO CEKANI NA FINALIZER ****");
        }


    }

    private void invokeLoaders() {
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

    private boolean isLoadingComplete() {
        if (isFolderStorageEmpty()) {
            for (Runner runner : runners) {
                if (runner.getStatus() == Runner.RUNNING) {
                    System.out.println(runner.getName() + "stale beziii");
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }

    }

    public void checkLoadingProcess() {
        if (isLoadingComplete()) {
            loadingComplete = true;
            setLoadersInactive();
            complete();
        }
    }

    private synchronized void setLoadersInactive() {
        for (Runner runner : runners) {
            runner.interrupt();
        }
    }

    private synchronized void complete() {
        synchronized (finalizer) {
            finalizer.setComplete(true);
            finalizer.notify();
        }
    }
}
