package cz.jfx.CodeAnalyser.Control;

import cz.jfx.CodeAnalyser.Storage.IStorage;
import cz.jfx.CodeAnalyser.TaskManager.TaskManager;

/**
 *
 * @author Felix
 */
public class AnalyserController {

    private TaskManager taskManager;
    private IStorage fileStorage;
    private IStorage folderStorage;

    private AnalyserController() {
    }

    public IStorage getFileStorage() {
        return fileStorage;
    }

    public void setFileStorage(IStorage fileStorage) {
        this.fileStorage = fileStorage;
    }

    public IStorage getFolderStorage() {
        return folderStorage;
    }

    public void setFolderStorage(IStorage folderStorage) {
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

    private static class AnalyserControllerHolder {

        private static final AnalyserController INSTANCE = new AnalyserController();
    }
}
