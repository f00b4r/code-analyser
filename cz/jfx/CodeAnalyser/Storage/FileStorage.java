package cz.jfx.CodeAnalyser.Storage;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Felix
 */
public class FileStorage<E> implements IStorage<E> {

    private Queue<E> files = new LinkedList();

    public FileStorage() {
    }

    public synchronized void push(E f) {
        files.add(f);
    }

    public synchronized E poll() {
        return files.poll();
    }

    public synchronized boolean isEmpty() {
        return files.isEmpty();
    }

    public Iterator<E> iterator() {
        return files.iterator();
    }
}
