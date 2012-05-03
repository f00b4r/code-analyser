package cz.jfx.CodeAnalyser;

import cz.jfx.CodeAnalyser.Config.Config;
import cz.jfx.CodeAnalyser.Control.AnalyserController;
import cz.jfx.CodeAnalyser.GUI.MainView;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.BusinessBlackSteelSkin;
import org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceModerateLookAndFeel;

/**
 *
 * @author Felix
 */
public class CodeAnalyser {

    public static final String CONFIG_FILE = "./default.config";

    public static void main(String[] args) {
        CodeAnalyser ca = new CodeAnalyser();

        // Load custom/defaul settings
        if ((new File(CONFIG_FILE)).exists()) {
            Config.getInstance().load(CONFIG_FILE);
        } else {
            Config.getInstance().startup();
        }

        // start GUI & main controller
        ca.start();
    }

    private void start() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    javax.swing.UIManager.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());
                    JFrame.setDefaultLookAndFeelDecorated(true);
                    JDialog.setDefaultLookAndFeelDecorated(true);
                } catch (UnsupportedLookAndFeelException ex) {
                    try {
                        javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex1) {
                    }
                }

                MainView mv = new MainView();
                AnalyserController.getInstance().setView(mv);
                mv.setVisible(true);
            }
        });

    }
}
