package com.example.threads.extendsthread;

// there is a second way of creating tasks for a new thread
// by extending your task with the Thread class
// the thread class implements the Runnable interface
// so we can overwrite the run method of the inherited Thread class
// but the preferred way ist to implement the runnable interface
public class SimpleTask extends Thread {
    // we override our run method from the Thread class
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
