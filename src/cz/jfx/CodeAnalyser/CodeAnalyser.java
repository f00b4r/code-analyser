package cz.jfx.CodeAnalyser;

import cz.jfx.CodeAnalyser.Control.AnalyserController;
import cz.jfx.CodeAnalyser.GUI.MainView;
import javax.swing.UnsupportedLookAndFeelException;
import org.pushingpixels.substance.api.skin.SubstanceModerateLookAndFeel;

/**
 *
 * @author Felix
 */
public class CodeAnalyser {

    public static void main(String[] args) {
        CodeAnalyser ca = new CodeAnalyser();

        // start GUI & main controller
        ca.start();
    }

    private void start() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    javax.swing.UIManager.setLookAndFeel(new SubstanceModerateLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                }

                MainView mv = new MainView();
                AnalyserController.getInstance().setView(mv);
                mv.setVisible(true);
            }
        });

    }
}
