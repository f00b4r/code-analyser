package cz.jfx.CodeAnalyser.GUI;

import cz.jfx.CodeAnalyser.Control.AnalyserController;
import cz.jfx.CodeAnalyser.TaskManager.Listeners.FileListener;
import javax.swing.JLabel;

/**
 *
 * @author Felix
 */
public class Counter {

    public JLabel actual;
    public JLabel total;

    public Counter(JLabel actual, JLabel total) {
        this.actual = actual;
        this.total = total;
        //addHandler();
    }
//
//    private void addHandler() {
//        AnalyserController.getInstance().getTaskManager().addFileListener(new FileListener() {
//
//            @Override
//            public void added(int count) {
//                actual.setText(String.valueOf(count));
//            }
//
//            @Override
//            public void remove(int count) {
//                actual.setText(String.valueOf(count));
//            }
//
//            @Override
//            public void complete() {
//                System.out.println("****************************** VSEECHNO JE HOTOVO ******************************");
//            }
//        });
//    }
}
