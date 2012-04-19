package cz.jfx.CodeAnalyser.Filters;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author Felix
 */
public class CodeFilter implements FileFilter {

    public enum Extensions {

        html,
        css,
        js,
        latte,
        php,
        java;
    }

    @Override
    public boolean accept(File file) {
        
        if(file.isDirectory()) {
            return true;
        }
        
        for (Extensions e : Extensions.values()) {
            if (file.getName().endsWith(e.name())) {
                return true;
            }
        }

        return false;
    }
}
