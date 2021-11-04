package threadpools;

// every task that should run in a seperate thread
// implements the Runnable interface
// which exposes the run method
public class SimpleTask2 implements Runnable {
    // we override our run method from the interface
    // in the run method is every code
    // that should be executed in a separate thread
    @Override
    public void run() {
        try {
            // some heavy task that should not run  in the main thread
            // we simply sleep for a random time between 0,5 and 2 seconds
            Thread.sleep(this.getMillis());
        } catch (InterruptedException e) {
            System.out.println("got interrupted" + e);
        }
    }

    private int getMillis() {
        // return an integer between 500 and 2000
        return (int) (Math.random() * 500 + 2_000);
    }
}
