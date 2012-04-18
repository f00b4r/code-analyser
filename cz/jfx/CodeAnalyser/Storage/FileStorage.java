package cz.jfx.CodeAnalyser.Storage;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Felix
 */
public class FileStorage implements IStorage {

    private Queue<File> files = new LinkedList();

    public FileStorage() {
    }

    public synchronized void push(File f) {
        files.add(f);
    }

    public synchronized File poll() {
        return files.poll();
    }

    public synchronized boolean isEmpty() {
        return files.isEmpty();
    }
}
