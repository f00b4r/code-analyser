package cz.jfx.CodeAnalyser.Storage;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Felix
 */
public class FolderStorage<E> implements IStorage<E> {

    private Queue<E> folders = new LinkedList();

    public FolderStorage() {
    }

    public synchronized void push(E f) {
        folders.add(f);
    }

    public synchronized E poll() {
        return folders.poll();
    }

    public synchronized boolean isEmpty() {
        return folders.isEmpty();
    }

    public Iterator<E> iterator() {
        return folders.iterator();
    }

    public int size() {
        return folders.size();
    }
}
