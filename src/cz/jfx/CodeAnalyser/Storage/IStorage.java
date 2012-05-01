package cz.jfx.CodeAnalyser.Storage;

import java.util.Iterator;

/**
 *
 * @author Felix
 */
public interface IStorage<E> {

    public void push(E f);

    public E poll();

    public boolean isEmpty();
    
    public Iterator<E> iterator();
    
    public int size();
    
    public void clear();
}
