package cz.jfx.CodeAnalyser.TaskManager;

import cz.jfx.CodeAnalyser.Control.AnalyserController;
import cz.jfx.CodeAnalyser.TaskManager.Runners.Runner;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felix
 */
public class TaskManager {

    private ArrayList<Runner> jobs;
    private Finalizer finalizer;
    private AnalyserController controller;
    private static final Logger logger = Logger.getLogger(TaskManager.class.getName());

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
        logger.entering("TaskManager", "start");

        finalizer.start();

        // spusteni nacitacich vlaken
        logger.info("Run threads");
        run();

        try {
            finalizer.join();
        } catch (InterruptedException ex) {
            logger.warning("TaskManager intterupted");
        }

        clean();
        logger.exiting("TaskManager", "start");
    }

    public synchronized void closeJob(Class t) {
        for (Runner job : jobs) {
            if (job.getClass() == t) {
                logger.log(Level.FINE, "intterupting {0}", job.getName());
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
        logger.fine("Job invoking");
        for (Runner job : jobs) {
            if (job.getClass() == t && job.getStatus() == Runner.WAITING) {
                // invoke only one waiting job..
                synchronized (job) {
                    logger.log(Level.FINE, "{0} - notify", job.getName());
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
                logger.log(Level.FINE, "Still running - {0}", job.getName());
                // Any job, still running
                return;
            }
        }

        finalizer.interrupt();
    }

    public void complete(Class t) {
        closeJob(t);
        finalizer.interrupt();
    }

    private void clean() {
        logger.fine("Clean TaskManager");
        jobs = new ArrayList<>();
        finalizer = new Finalizer();
    }
}
