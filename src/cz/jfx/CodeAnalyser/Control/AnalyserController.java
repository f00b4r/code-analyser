package cz.jfx.CodeAnalyser.Control;

import cz.jfx.CodeAnalyser.Filters.CodeFilter;
import cz.jfx.CodeAnalyser.GUI.MainView;
import cz.jfx.CodeAnalyser.Storage.FileStorage;
import cz.jfx.CodeAnalyser.Storage.FolderStorage;
import cz.jfx.CodeAnalyser.Storage.IStorage;
import cz.jfx.CodeAnalyser.TaskManager.TaskManager;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.EventListener;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.event.EventListenerList;

/**
 *
 * @author Felix
 */
public class AnalyserController {

    private TaskManager taskManager = new TaskManager();
    private LoaderController loaderController;
    private ReaderController readerController;
    private IStorage<File> fileStorage = new FileStorage<>();
    private IStorage<File> folderStorage = new FolderStorage<>();
    private FileFilter codeFilter = new CodeFilter();
    private MainView view;
    public EventListenerList listeners = new EventListenerList();
    public static final Logger logger = Logger.getLogger("CodeAnalyser");

    private AnalyserController() {
        try {
            FileHandler fileHandler = new FileHandler("analyser.log");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.setLevel(Level.ALL);
            logger.addHandler(fileHandler);
        } catch (IOException | SecurityException ex) {
        }

        loaderController = new LoaderController(this);
        readerController = new ReaderController(this);
        logger.fine("AnalyserController started");
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

    public void addListener(Class t, EventListener listener) {
        listeners.add(t, listener);
    }

    public LoaderController getLoaderController() {
        return loaderController;
    }

    public ReaderController getReaderController() {
        return readerController;
    }

    private void cleanStorages() {
        folderStorage.clear();
        fileStorage.clear();
    }

    public void analyse() {
        logger.entering("AnalyserController", "analyse");

        cleanStorages();

        folderStorage.push(view.getSelectedFolder());
        loaderController.init();
        taskManager.start();

        logger.exiting("AnalyserController", "analyse");

    }
}
