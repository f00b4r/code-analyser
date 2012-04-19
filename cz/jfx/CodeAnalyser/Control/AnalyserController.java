package cz.jfx.CodeAnalyser.Control;

import cz.jfx.CodeAnalyser.Filters.CodeFilter;
import cz.jfx.CodeAnalyser.Storage.IStorage;
import cz.jfx.CodeAnalyser.TaskManager.TaskManager;
import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author Felix
 */
public class AnalyserController {

    private TaskManager taskManager;
    private IStorage<File> fileStorage;
    private IStorage<File> folderStorage;
    private FileFilter codeFilter = new CodeFilter();

    private AnalyserController() {
    }

    public IStorage<File> getFileStorage() {
        return fileStorage;
    }

    public void setFileStorage(IStorage<File> fileStorage) {
        this.fileStorage = fileStorage;
    }

    public IStorage<File> getFolderStorage() {
        return folderStorage;
    }

    public void setFolderStorage(IStorage<File> folderStorage) {
        this.folderStorage = folderStorage;
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }

    public void setTaskManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public static AnalyserController getInstance() {
        return AnalyserControllerHolder.INSTANCE;
    }

    public FileFilter getCodeFilter() {
        return codeFilter;
    }

    private static class AnalyserControllerHolder {

        private static final AnalyserController INSTANCE = new AnalyserController();
    }
}
