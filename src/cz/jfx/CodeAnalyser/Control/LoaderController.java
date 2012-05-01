package cz.jfx.CodeAnalyser.Control;

import cz.jfx.CodeAnalyser.TaskManager.Listeners.FileListener;
import cz.jfx.CodeAnalyser.TaskManager.Listeners.FolderListener;
import cz.jfx.CodeAnalyser.TaskManager.Listeners.JobListener;
import cz.jfx.CodeAnalyser.TaskManager.Runners.Loader;
import java.io.File;

/**
 *
 * @author Felix
 */
public class LoaderController {

    private AnalyserController context;

    LoaderController(AnalyserController context) {
        this.context = context;
    }

    LoaderController() {
        this.context = AnalyserController.getInstance();
    }

    public void init() {
        context.getTaskManager().addJob(new Loader("Loader1", context.getTaskManager(), this));
        context.getTaskManager().addJob(new Loader("Loader2", context.getTaskManager(), this));
        context.getTaskManager().addJob(new Loader("Loader3", context.getTaskManager(), this));
    }

    /**
     * FolderStorage
     */
    public synchronized File nextFolder() {
        fireFolderRemoved();
        return context.getFolderStorage().poll();
    }

    public synchronized void addFolder(File f) {
        context.getFolderStorage().push(f);
        context.getTaskManager().invokeJob(Loader.class);
        fireFolderAdded();
    }

    public synchronized boolean isFolderStorageEmpty() {
        return context.getFolderStorage().isEmpty();
    }

    /**
     * FileStorage
     */
    public synchronized File nextFile(File f) {
        fireFileRemoved();
        return context.getFileStorage().poll();
    }

    public synchronized void addFile(File f) {
        context.getFileStorage().push(f);
        fireFileAdded();
    }

    public synchronized boolean isFileStorageEmpty() {
        return context.getFileStorage().isEmpty();
    }

    public synchronized void checkLoadingProcess() {
        if (isFolderStorageEmpty()) {
            if (!context.getTaskManager().isJobsActive(Loader.class)) {
                context.getTaskManager().closeJob(Loader.class);
                context.getTaskManager().complete();
            }
        }
    }

    private void fireJobComlete() {
        for (JobListener listener : context.listeners.getListeners(JobListener.class)) {
            listener.complete();
        }
    }

    private void fireFileAdded() {
        for (FileListener listener : context.listeners.getListeners(FileListener.class)) {
            listener.added(context.getFileStorage(), context.getFileStorage().size());
        }
    }

    private void fireFileRemoved() {
        for (FileListener listener : context.listeners.getListeners(FileListener.class)) {
            listener.removed(context.getFileStorage(), context.getFileStorage().size());
        }
    }

    private void fireFolderAdded() {
        for (FolderListener listener : context.listeners.getListeners(FolderListener.class)) {
            listener.added(context.getFileStorage(), context.getFileStorage().size());
        }
    }

    private void fireFolderRemoved() {
        for (FolderListener listener : context.listeners.getListeners(FolderListener.class)) {
            listener.removed(context.getFileStorage(), context.getFileStorage().size());
        }
    }
}
