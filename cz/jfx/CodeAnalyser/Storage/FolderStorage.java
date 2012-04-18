package cz.jfx.CodeAnalyser.Storage;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Felix
 */
public class FolderStorage implements IStorage {

    private Queue<File> folders = new LinkedList();

    public FolderStorage() {
    }

    public synchronized void push(File f) {
        folders.add(f);
    }

    public synchronized File poll() {
        return folders.poll();
    }

    public synchronized boolean isEmpty() {
        return folders.size() <= 0;
    }
}
