package cz.jfx.CodeAnalyser.TaskManager;

import java.util.logging.Logger;

/**
 *
 * @author Felix
 */
public class Finalizer extends Thread {

    private static final Logger logger = Logger.getLogger(Finalizer.class.getName());

    public void run() {
        logger.entering("Finalizer", "run");
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException ex) {
                logger.info("Finalizer intterupted!");
            }
        }
        logger.exiting("Finalizer", "run");
    }
}
