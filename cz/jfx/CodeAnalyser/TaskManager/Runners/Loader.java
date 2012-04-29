package cz.jfx.CodeAnalyser.TaskManager.Runners;

import cz.jfx.CodeAnalyser.Control.LoaderController;
import cz.jfx.CodeAnalyser.TaskManager.TaskManager;
import java.io.File;

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
            //System.out.println(Thread.currentThread().getName() + " - starting..");
            setStatus(Runner.RUNNING);

            // Checking, if storage is empty..
            if (controller.isFolderStorageEmpty()) {
                // Then waiting..
                synchronized (this) {
                    try {
                        setStatus(Runner.WAITING);
                        controller.checkLoadingProcess();
                        //System.out.println(Thread.currentThread().getName() + "Waiting..");
                        wait();
                        continue;
                    } catch (InterruptedException ex) {
                        //System.out.println(Thread.currentThread().getName() + " interrupted!");
                        setRunning(false);
                        setStatus(Runner.OFF);
                        break;
                    }
                }
            }

            // Search and process files + folders
            search(controller.nextFolder());

            // Yielding..
            //System.out.println(Thread.currentThread().getName() + " - yield()");
            yield();
        }
    }

    private void search(File folder) {
        if (folder == null) {
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
                    //System.out.println(Thread.currentThread().getName() + " Soubor: " + f.getAbsolutePath());
                } else if (f.isDirectory()) {
                    controller.addFolder(f);
                    //System.out.println(Thread.currentThread().getName() + " Adresar : " + f.getAbsolutePath());
                }
            }
        }
    }
}
