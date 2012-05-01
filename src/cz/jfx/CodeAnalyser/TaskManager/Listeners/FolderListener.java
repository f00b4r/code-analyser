package cz.jfx.CodeAnalyser.TaskManager.Listeners;

import cz.jfx.CodeAnalyser.Storage.IStorage;

/**
 *
 * @author Felix
 */
public interface FolderListener extends JobListener{

    public void added(IStorage storage, int count);

    public void removed(IStorage storage, int count);

}
