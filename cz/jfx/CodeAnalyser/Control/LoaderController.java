package cz.jfx.CodeAnalyser.Control;

import cz.jfx.CodeAnalyser.Storage.IStorage;
import cz.jfx.CodeAnalyser.TaskManager.Runners.Loader;
import cz.jfx.CodeAnalyser.TaskManager.TaskManager;
import java.io.File;

/**
 *
 * @author Felix
 */
public class LoaderController {

    private TaskManager tm;
    private IStorage<File> folderStorage;
    private IStorage<File> fileStorage;

    public void launch() {
        tm = AnalyserController.getInstance().getTaskManager();
        folderStorage = AnalyserController.getInstance().getFolderStorage();
        fileStorage = AnalyserController.getInstance().getFileStorage();
        init();
    }

    public void launch(TaskManager tm, IStorage<File> folderStorage, IStorage<File> fileStorage) {
        this.tm = tm;
        this.folderStorage = folderStorage;
        this.fileStorage = fileStorage;
        init();
    }

    private void init() {
        tm.addJob(new Loader("Loader1", tm, this));
        tm.addJob(new Loader("Loader2", tm, this));
        tm.addJob(new Loader("Loader3", tm, this));
    }

    /**
     * FolderStorage
     */
    public synchronized File nextFolder() {
        return folderStorage.poll();
    }

    public synchronized void addFolder(File f) {
        folderStorage.push(f);
        tm.aliveJob(Loader.class);
        //fireFolderAdded();
    }

    public synchronized boolean isFolderStorageEmpty() {
        return folderStorage.isEmpty();
    }

    /**
     * FileStorage
     */
    public synchronized File nextFile(File f) {
        return fileStorage.poll();
    }

    public synchronized void addFile(File f) {
        fileStorage.push(f);
        //fireFileAdded();
    }

    public synchronized boolean isFileStorageEmpty() {
        return fileStorage.isEmpty();
    }

    public synchronized void checkLoadingProcess() {
        if (isFolderStorageEmpty()) {
            if (!tm.isJobsActive(Loader.class)) {
                tm.closeJob(Loader.class);
                tm.complete();
            }
        }
    }
}
