package cz.jfx.CodeAnalyser.Config;

import cz.jfx.CodeAnalyser.Control.AnalyserController;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * @author Felix
 */
public class Config {

    public static final Config instance = new Config();
    private ResourceBundle application = ResourceBundle.getBundle("cz/jfx/CodeAnalyser/Config/application");
    private ResourceBundle defaults = ResourceBundle.getBundle("cz/jfx/CodeAnalyser/Config/defaults");
    private Properties properties = new Properties();

    public static String getValue(String key) {
        if (instance.application.containsKey(key)) {
            return instance.application.getString(key);
        }
        return null;
    }

    public void load(String filename) {
        try {
            properties.load(new FileInputStream(filename));
        } catch (IOException e) {
            AnalyserController.logger.warning("load fail");
            AnalyserController.logger.warning(e.getMessage());
        }
    }

    public void store(String filename) {
        try {
            if (properties.isEmpty()) {
                storeDefaults(defaults);
            }
            properties.store(new FileOutputStream(filename), "CodeAnalyse: default settings");
        } catch (IOException e) {
            AnalyserController.logger.warning("store fail");
            AnalyserController.logger.warning(e.getMessage());
        }
    }

    private void storeDefaults(ResourceBundle resource) {
        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            properties.put(key, resource.getString(key));
        }
    }

    public static Config getInstance() {
        return instance;
    }
}
