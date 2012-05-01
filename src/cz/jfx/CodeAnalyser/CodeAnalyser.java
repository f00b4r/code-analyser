package cz.jfx.CodeAnalyser;

import cz.jfx.CodeAnalyser.Config.Config;
import cz.jfx.CodeAnalyser.Control.AnalyserController;
import cz.jfx.CodeAnalyser.GUI.MainView;
import javax.swing.UnsupportedLookAndFeelException;
import org.pushingpixels.substance.api.skin.SubstanceModerateLookAndFeel;

/**
 *
 * @author Felix
 */
public class CodeAnalyser {

    public static final String CONFIG_FILE = "./config.dat";

    public static void main(String[] args) {
        CodeAnalyser ca = new CodeAnalyser();

        // Load custom/defaul settings
        Config.getInstance().load(CONFIG_FILE);

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
