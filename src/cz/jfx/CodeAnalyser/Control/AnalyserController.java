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

    /**
     * Private constructor,
     * idea of singleton a.k.a MainController
     */
    private AnalyserController() {
        try {
            // Init Logger handle 
            // and standalone logger
            FileHandler fileHandler = new FileHandler("analyser.log");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.setLevel(Level.ALL);
            logger.addHandler(fileHandler);
        } catch (IOException | SecurityException ex) {
        }

        // Set up 
        loaderController = new LoaderController(this);
        readerController = new ReaderController(this);

        logger.fine("AnalyserController started");

    }

    /**
     * Gets a MainView 
     * @return 
     */
    public MainView getView() {
        return view;
    }

    /**
     * Sets the MainView
     * @param view 
     */
    public void setView(MainView view) {
        this.view = view;
    }

    /**
     * Gets a storage for files
     * @return 
     */
    public IStorage<File> getFileStorage() {
        return fileStorage;
    }

    /**
     * Sets the storage for files
     * @param fileStorage 
     */
    public void setFileStorage(IStorage<File> fileStorage) {
        this.fileStorage = fileStorage;
    }

    /**
     * Gets a storage for folders
     * @return 
     */
    public IStorage<File> getFolderStorage() {
        return folderStorage;
    }

    /**
     * Sets the storage for folders
     * @param folderStorage 
     */
    public void setFolderStorage(IStorage<File> folderStorage) {
        this.folderStorage = folderStorage;
    }

    /**
     * Gets a TaskManager for job monitoring
     * @return 
     */
    public TaskManager getTaskManager() {
        return taskManager;
    }

    /**
     * Sets the TaskManager for job monitoring
     * @param taskManager 
     */
    public void setTaskManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    /**
     * Gets a CodeFilter (according to extensions)
     * @return 
     */
    public FileFilter getCodeFilter() {
        return codeFilter;
    }

    /**
     * Return instance of AnalyseController (Context)
     * @return 
     */
    public static AnalyserController getInstance() {
        return AnalyserControllerHolder.INSTANCE;
    }

    /**
     * InstanceHolder
     */
    private static class AnalyserControllerHolder {

        private static final AnalyserController INSTANCE = new AnalyserController();
    }

    /**
     * Adds a EventListener 
     * @param t
     * @param listener 
     */
    public void addListener(Class t, EventListener listener) {
        listeners.add(t, listener);
    }

    /**
     * Return the LoaderController
     * @return 
     */
    public LoaderController getLoaderController() {
        return loaderController;
    }

    /**
     * Return the ReaderController
     * @return 
     */
    public ReaderController getReaderController() {
        return readerController;
    }

    /**
     * Clean up storages
     */
    private void cleanStorages() {
        folderStorage.clear();
        fileStorage.clear();
    }

    /**
     * Method for complex analyse, starts all importat services and dependencies
     */
    public void analyse() {
        logger.entering("AnalyserController", "analyse");

        cleanStorages();

        folderStorage.push(view.getSelectedFolder());
        loaderController.init();
        taskManager.start();

        logger.exiting("AnalyserController", "analyse");

    }
}
