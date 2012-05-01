package cz.jfx.CodeAnalyser.TaskManager;

import cz.jfx.CodeAnalyser.Control.AnalyserController;
import cz.jfx.CodeAnalyser.TaskManager.Runners.Runner;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author Felix
 */
public class TaskManager {

    private ArrayList<Runner> jobs;
    private Finalizer finalizer;
    private AnalyserController controller;

    public TaskManager() {
        clean();
    }

    public void addJob(Runner job) {
        jobs.add(job);
    }

    /*
     * TaskManager function
     */
    public void start() {
        AnalyserController.logger.entering("TaskManager", "start");

        finalizer.start();

        // spusteni nacitacich vlaken
        AnalyserController.logger.fine("Run threads");
        run();

        try {
            finalizer.join();
        } catch (InterruptedException ex) {
            AnalyserController.logger.warning("TaskManager intterupted");
        }

        clean();
        AnalyserController.logger.exiting("TaskManager", "start");
    }

    public synchronized void closeJob(Class t) {
        for (Runner job : jobs) {
            if (job.getClass() == t) {
                job.interrupt();
            }
        }
    }

    public synchronized boolean isJobsActive(Class t) {
        for (Runner job : jobs) {
            if (job.getStatus() == Runner.RUNNING && job.getClass() == t) {
                return true;
            }
        }

        return false;
    }

    public void invokeJob(Class t) {
        AnalyserController.logger.fine("Job invoking");
        for (Runner job : jobs) {
            if (job.getClass() == t && job.getStatus() == Runner.WAITING) {
                // invoke only one waiting job..
                synchronized (job) {
                    AnalyserController.logger.log(Level.FINER, "{0} - notify", job.getName());
                    job.setRunning(true);
                    job.notify();
                }
                break;
            }
        }
    }

    private synchronized void run() {
        for (Runner job : jobs) {
            job.start();
        }
    }

    public synchronized void complete() {
        for (Runner job : jobs) {
            if (job.isRunning()) {
                // Any job, still running
                return;
            }
        }
        finalizer.interrupt();
    }

    private void clean() {
        AnalyserController.logger.finer("Clean TaskManager");
        jobs = new ArrayList<>();
        finalizer = new Finalizer();
    }
}
