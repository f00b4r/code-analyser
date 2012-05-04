package cz.jfx.CodeAnalyser.Control;

import cz.jfx.CodeAnalyser.Config.Config;
import cz.jfx.CodeAnalyser.TaskManager.Listeners.FileListener;
import cz.jfx.CodeAnalyser.TaskManager.Listeners.FolderListener;
import cz.jfx.CodeAnalyser.TaskManager.Listeners.JobListener;
import cz.jfx.CodeAnalyser.TaskManager.Runners.Loader;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felix
 */
public class LoaderController {

    private AnalyserController context;
    private static final Logger logger = Logger.getLogger(LoaderController.class.getName());
    
    LoaderController(AnalyserController context) {
        this.context = context;
    }

    LoaderController() {
        this.context = AnalyserController.getInstance();
    }

    /**
     * Startup function for loading process
     * Adds loading threads
     */
    public void init() {
        // Gets a settings
        String countLoaders = (Config.getProperty("Threads.loaders") == null ? "1" : Config.getProperty("Threads.loaders"));
        // Add many threads as is possibles
        for (int i = 1; i <= Integer.parseInt(countLoaders); i++) {
            logger.log(Level.FINE, "Added loader{0}", i);
            context.getTaskManager().addJob(new Loader("Loader" + i, context.getTaskManager(), this));
        }
    }

    /**
     * FolderStorage *********************************************************************
     */
    /**
     * Gets a pointered folder from folder storage
     * @return Folder from storage
     */
    public synchronized File nextFolder() {
        fireFolderRemoved(); // fire event
        return context.getFolderStorage().poll();
    }

    /**
     * Push folder into folder storage
     * @param f - the File
     */
    public synchronized void addFolder(File f) {
        context.getFolderStorage().push(f);
        context.getTaskManager().invokeJob(Loader.class);
        fireFolderAdded(); // fire event
    }

    /**
     * Return true if folder storage is empty, false if isnt
     * @return true if is it empty, otherwise false
     */
    public synchronized boolean isFolderStorageEmpty() {
        return context.getFolderStorage().isEmpty();
    }

    /**
     * FileStorage *********************************************************************
     */
    /**
     * Gets a pointered file from file storage
     * @return File from storage
     */
    public synchronized File nextFile() {
        fireFileRemoved(); // fire event
        return context.getFileStorage().poll();
    }

    /**
     * Push file into file storage
     * @param f - the File
     */
    public synchronized void addFile(File f) {
        context.getFileStorage().push(f);
        fireFileAdded(); // fire event
    }

    /**
     * Return true if file storage is empty, false if isnt
     * @return true if is it empty, otherwise false
     */
    public synchronized boolean isFileStorageEmpty() {
        return context.getFileStorage().isEmpty();
    }

    /**
     * Monitor loading process,
     * kill all loading threads for inactive
     */
    public synchronized void checkLoadingProcess() {
        if (isFolderStorageEmpty()) {
            // Check active threads
            if (!context.getTaskManager().isJobsActive(Loader.class)) {
                // Kill loaders and indicate loading complete
                context.getTaskManager().complete(Loader.class);
            }
        }
    }

    /**
     * Loading listeners 
     */
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
