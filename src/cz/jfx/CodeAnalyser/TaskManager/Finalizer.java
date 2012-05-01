package cz.jfx.CodeAnalyser.TaskManager;

import cz.jfx.CodeAnalyser.Control.AnalyserController;

/**
 *
 * @author Felix
 */
public class Finalizer extends Thread {

    public void run() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException ex) {
                AnalyserController.logger.info("Finalizer innterupted!");
            }
        }
        AnalyserController.logger.fine("Konec finalizeru!!!");
    }
}
