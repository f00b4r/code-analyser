package cz.jfx.CodeAnalyser.TaskManager.Runners;

import cz.jfx.CodeAnalyser.TaskManager.TaskManager;
import java.io.FileFilter;

/**
 *
 * @author Felix
 */
public class Runner extends Thread {

    public static final int RUNNING = 1;
    public static final int WAITING = 0;
    public static final int OFF = -1;
    protected TaskManager tm;
    protected int status;
    protected boolean running = true;
    protected FileFilter filter;

    public FileFilter getFilter() {
        return filter;
    }

    public void setFilter(FileFilter filter) {
        this.filter = filter;
    }

    public Runner(TaskManager tm) {
        super("Custom-Thread-" + Math.random());
        this.tm = tm;
    }

    public Runner(String name, TaskManager tm) {
        super(name);
        this.tm = tm;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public TaskManager getTm() {
        return tm;
    }

    public void setTm(TaskManager tm) {
        this.tm = tm;
    }
}
