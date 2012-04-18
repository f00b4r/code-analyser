package cz.jfx.CodeAnalyser.TaskManager;

/**
 *
 * @author Felix
 */
public class Finalizer extends Thread {

    private boolean complete = false;

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void run() {
        while (!complete) {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    System.out.println("Finalizer innterupted!");
                    complete = true;
                    break;
                }
            }
        }
        
        System.out.println("Konec finalizeru!!!");
    }
}
