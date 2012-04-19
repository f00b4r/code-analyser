package cz.jfx.CodeAnalyser.TaskManager.Listeners;

/**
 *
 * @author Felix
 */
public interface FileListener extends JobListener {

    public void added(int count);

    public void remove(int count);
}
