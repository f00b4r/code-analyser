package cz.jfx.CodeAnalyser.TaskManager.Runners;

import cz.jfx.CodeAnalyser.Control.AnalyserController;
import cz.jfx.CodeAnalyser.Control.LoaderController;
import cz.jfx.CodeAnalyser.TaskManager.TaskManager;
import java.io.File;
import java.util.logging.Level;

/**
 *
 * @author Felix
 */
public class Loader extends Runner {

    private LoaderController controller;

    public Loader(TaskManager tm, LoaderController controller) {
        super(tm);
        this.controller = controller;
    }

    public Loader(String name, TaskManager tm, LoaderController controller) {
        super(name, tm);
        this.controller = controller;
    }

    public void run() {
        while (running) {
            AnalyserController.logger.log(Level.FINE, "{0} - starting..", Thread.currentThread().getName());
            setStatus(Runner.RUNNING);

            // Checking, if storage is empty..
            if (controller.isFolderStorageEmpty()) {
                // Then waiting..
                synchronized (this) {
                    try {
                        setStatus(Runner.WAITING);
                        controller.checkLoadingProcess();
                        AnalyserController.logger.log(Level.FINE, "{0}Waiting..", Thread.currentThread().getName());
                        wait();
                        continue;
                    } catch (InterruptedException ex) {
                        AnalyserController.logger.log(Level.FINE, "{0} interrupted!", Thread.currentThread().getName());
                        setRunning(false);
                        setStatus(Runner.OFF);
                        break;
                    }
                }
            }

            // Search and process files + folders
            search(controller.nextFolder());

            // Yielding..
            AnalyserController.logger.log(Level.FINE, "{0} - yield()", Thread.currentThread().getName());
            yield();
        }
    }

    private void search(File folder) {
        if (folder == null || !folder.isDirectory()) {
            return;
        }

        File[] objects;
        if (filter != null) {
            objects = folder.listFiles(filter);
        } else {
            objects = folder.listFiles();
        }

        if (objects == null || objects.length == 0) {
            return;
        }

        for (File f : objects) {
            if (f.canRead()) {
                if (f.isFile()) {
                    controller.addFile(f);
                    AnalyserController.logger.log(Level.FINEST, "{0} Soubor: {1}", new Object[]{Thread.currentThread().getName(), f.getAbsolutePath()});
                } else if (f.isDirectory()) {
                    controller.addFolder(f);
                    AnalyserController.logger.log(Level.FINEST, "{0} Adresar : {1}", new Object[]{Thread.currentThread().getName(), f.getAbsolutePath()});
                }
            }
        }
    }
}
