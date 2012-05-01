package cz.jfx.CodeAnalyser.GUI;

import cz.jfx.CodeAnalyser.Control.AnalyserController;
import cz.jfx.CodeAnalyser.Storage.IStorage;
import cz.jfx.CodeAnalyser.TaskManager.Listeners.FileListener;
import javax.swing.JLabel;

/**
 *
 * @author Felix
 */
public class FileCounter {

    public JLabel total;

    public FileCounter(JLabel total) {
        this.total = total;
        addHandler();
    }

    private void addHandler() {
        AnalyserController.getInstance().addListener(FileListener.class, new FileListener() {

            @Override
            public void added(IStorage fileStorage, int count) {
                total.setText(String.valueOf(count));
            }

            @Override
            public void removed(IStorage fileStorage, int count) {
                total.setText(String.valueOf(count));
            }

            @Override
            public void complete() {
            }
        });
    }
}
