package cz.jfx.CodeAnalyser.GUI;

import cz.jfx.CodeAnalyser.TaskManager.Listeners.FileListener;
import cz.jfx.CodeAnalyser.TaskManager.TaskManager;
import javax.swing.JComponent;

/**
 *
 * @author Felix
 */
public class Counter {

    private TaskManager tm;

    public Counter(TaskManager tm) {
        this.tm = tm;
        tm.addFileListener(new FileListener() {

            @Override
            public void added(int count) {
            }

            @Override
            public void remove(int count) {
            }

            @Override
            public void complete() {
                System.out.println("****************************** VSEECHNO JE HOTOVO ******************************");
            }
        });
    }

    public void attachComponent(JComponent c) {
    }
}
