package cz.jfx.CodeAnalyser;

import cz.jfx.CodeAnalyser.Control.AnalyserController;
import cz.jfx.CodeAnalyser.Storage.FileStorage;
import cz.jfx.CodeAnalyser.Storage.FolderStorage;
import cz.jfx.CodeAnalyser.TaskManager.TaskManager;
import java.io.File;
import java.util.Iterator;

/**
 *
 * @author Felix
 */
public class CodeAnalyser {

    public static void main(String[] args) {
        CodeAnalyser ca = new CodeAnalyser();

        // init storages
        //

        // start GUI & main controller
        ca.start();

        // start analyse
        ca.analyse();

    }

    private void start() {
        System.out.println("start()");

        /*
         * GUI PART
         */

        AnalyserController ac = AnalyserController.getInstance();

        // define dependecies
        ac.setTaskManager(new TaskManager());
        ac.setFileStorage(new FileStorage<File>());
        ac.setFolderStorage(new FolderStorage<File>());

        // pridam pridavaci vlakno
        ac.getTaskManager().addLoader();
        ac.getTaskManager().addLoader();
        ac.getTaskManager().addLoader();


        // pridam nejaky adresar
        ac.getFolderStorage().push(new File("D:/JAVA/ThreadHratky"));
    }

    private void analyse() {
        System.out.println("analyse() - begin");
        TaskManager tm = AnalyserController.getInstance().getTaskManager();
        tm.start();
        System.out.println("analyse() - over");
        
        System.out.println("Seznam souboru..");
        
        Iterator<File> i = AnalyserController.getInstance().getFileStorage().iterator();
        while(i.hasNext()) {
            System.out.println(i.next().getAbsolutePath());
        }
        
    }
}
