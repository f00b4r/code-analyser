package cz.jfx.CodeAnalyser.TaskManager.Runners;

import cz.jfx.CodeAnalyser.TaskManager.TaskManager;
import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Felix
 */
public class Loader extends Runner {

    public Loader(TaskManager tm) {
        super(tm);
    }

    public Loader(String name, TaskManager tm) {
        super(name, tm);
    }

    public void run() {
        while (running) {
            System.out.println(Thread.currentThread().getName() + " - starting..");
            setStatus(Runner.RUNNING);

            // Checking, if storage is empty..
            if (tm.isFolderStorageEmpty()) {
                // Then waiting..
                synchronized (this) {
                    try {
                        setStatus(Runner.WAITING);
                        tm.checkLoadingProcess();
                        System.out.println(Thread.currentThread().getName() + "Waiting..");
                        wait();
                        continue;
                    } catch (InterruptedException ex) {
                        System.out.println(Thread.currentThread().getName() + " interrupted!");
                        setRunning(false);
                        setStatus(Runner.OFF);
                        break;
                    }
                }
            }

            // Search and process files + folders
            search(tm.nextFolder());

            // Yielding..
            System.out.println(Thread.currentThread().getName() + " - yield()");
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

        if (objects.length == 0 || objects == null) {
            return;
        }

        for (File f : objects) {
            if (f.canRead()) {
                if (f.isFile()) {
                    tm.addFile(f);
                    System.out.println(Thread.currentThread().getName() + " Soubor: " + f.getAbsolutePath());
                } else if (f.isDirectory()) {
                    tm.addFolder(f);
                    System.out.println(Thread.currentThread().getName() + " Adresar : " + f.getAbsolutePath());
                }
            }
        }
    }
}
