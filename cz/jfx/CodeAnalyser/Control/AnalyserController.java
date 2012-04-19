package cz.jfx.CodeAnalyser.Control;

import cz.jfx.CodeAnalyser.Filters.CodeFilter;
import cz.jfx.CodeAnalyser.GUI.MainView;
import cz.jfx.CodeAnalyser.Storage.FileStorage;
import cz.jfx.CodeAnalyser.Storage.FolderStorage;
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
    private FileFilter codeFilter;
    private MainView view;

    private AnalyserController() {
        taskManager = new TaskManager();
        codeFilter = new CodeFilter();
        System.out.println("AnalyserController started");
    }

    public MainView getView() {
        return view;
    }

    public void setView(MainView view) {
        this.view = view;
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

    public void analyse() {

        taskManager.clean();
        
        // define dependecies
        fileStorage = new FileStorage<>();
        folderStorage = new FolderStorage<>();

        // pridam pridavaci vlakno
        taskManager.addLoaders(3);

        folderStorage.push(view.getSelectedFolder());

        System.out.println("analyse() - begin");
        taskManager.start();
        System.out.println("analyse() - over");

    }
}
