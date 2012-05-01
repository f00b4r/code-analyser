package cz.jfx.CodeAnalyser.GUI;

import cz.jfx.CodeAnalyser.Control.AnalyserController;
import cz.jfx.CodeAnalyser.Storage.IStorage;
import cz.jfx.CodeAnalyser.TaskManager.Listeners.FolderListener;
import javax.swing.JLabel;

/**
 *
 * @author Felix
 */
public class FolderCounter {

    public JLabel total;

    public FolderCounter(JLabel total) {
        this.total = total;
        addHandler();
    }

    private void addHandler() {
        AnalyserController.getInstance().addListener(FolderListener.class, new FolderListener() {

            @Override
            public void added(IStorage folderStorage, int count) {
                total.setText(String.valueOf(count));
            }

            @Override
            public void removed(IStorage folderStorage, int count) {
                total.setText(String.valueOf(count));
            }

            @Override
            public void complete() {
            }
        });
    }
}
