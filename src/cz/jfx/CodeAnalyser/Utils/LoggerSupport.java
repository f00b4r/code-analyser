package cz.jfx.CodeAnalyser.Utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Felix
 */
public class LoggerSupport {

    public static void init() {
        // Root logger
        Logger analyser = Logger.getLogger("cz.jfx.CodeAnalyser");
        analyser.setLevel(Level.FINEST);

        try {
            FileHandler fh = new FileHandler("./logger.log", false);
            fh.setLevel(Level.FINEST);
            fh.setFormatter(new SimpleFormatter());
            fh.setEncoding("UTF-8");
            analyser.addHandler(fh);
        } catch (IOException | SecurityException ex) {
            analyser.log(Level.SEVERE, "Logger error: {0}", ex.getMessage());
            System.exit(0);
        }
    }
}
