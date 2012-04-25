package cz.jfx.CodeAnalyser.TaskManager;

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
                System.out.println("Finalizer innterupted!");
            }
        }
        System.out.println("Konec finalizeru!!!");
    }
}
