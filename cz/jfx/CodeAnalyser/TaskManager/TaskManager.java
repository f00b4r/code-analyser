package cz.jfx.CodeAnalyser.TaskManager;

import cz.jfx.CodeAnalyser.Control.AnalyserController;
import cz.jfx.CodeAnalyser.TaskManager.Runners.Runner;
import java.util.ArrayList;

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

    public AnalyserController getController() {
        if (controller == null) {
            controller = AnalyserController.getInstance();
        }
        return controller;
    }

    /*
     * TaskManager function
     */
    public void start() {

        System.out.println("Spousti finalizer");
        finalizer.start();

        System.out.println("Spoustim vlakna");

        // spusteni nacitacich vlaken
        startJobs();

        try {
            finalizer.join();
        } catch (InterruptedException ex) {
            System.out.println("**** PRERUSENO CEKANI NA FINALIZER ****");
        }

        clean();
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

    public void aliveJob(Class t) {
        System.out.println("OZIVUJI JOB");
        for (Runner job : jobs) {
            if (job.getStatus() == Runner.WAITING && job.getClass() == t) {
                // invoke only one waiting job..
                synchronized (job) {
                    System.out.println("Notify()" + job.getName());
                    job.setRunning(true);
                    job.notify();
                }
                break;
            }
        }
    }

    public synchronized void startJobs() {
        for (Runner job : jobs) {
            job.start();
        }
    }

    public void complete() {
        finalizer.interrupt();
    }

    private void clean() {
        System.out.println("Clean TM");
        jobs = new ArrayList<>();
        finalizer = new Finalizer();
    }
}
