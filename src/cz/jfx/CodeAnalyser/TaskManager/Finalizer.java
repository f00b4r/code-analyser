package cz.jfx.CodeAnalyser.TaskManager;

import cz.jfx.CodeAnalyser.Control.AnalyserController;

/**
 *
 * @author Felix
 */
public class Finalizer extends Thread {

    public void run() {
        AnalyserController.logger.entering("Finalizer", "run");
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException ex) {
                AnalyserController.logger.info("Finalizer intterupted!");
            }
        }
        AnalyserController.logger.exiting("Finalizer", "run");
    }
}
