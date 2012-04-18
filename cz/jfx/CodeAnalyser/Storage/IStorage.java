package cz.jfx.CodeAnalyser.Storage;

import java.io.File;

/**
 *
 * @author Felix
 */
public interface IStorage {

    public void push(File f);

    public File poll();

    public boolean isEmpty();
}
