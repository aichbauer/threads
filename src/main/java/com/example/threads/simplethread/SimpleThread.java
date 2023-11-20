package com.example.threads.simplethread;

import java.util.ArrayList;

public class SimpleThread {

    public static void main(String[] args) {
        // we create an arraylist where we store our threads
        // this is only for demonstration purposes
        // we can write that also as
        // List<Thread> threads = new ArrayList();
        ArrayList<Thread> threads = new ArrayList();

        // we cerate a loop and instantiate 100 Tasks which implements the Runnable interface
        for(int i = 0; i <= 100; i++) {
            // we can also write that as
            // Runnable task = new SimpleTask();
            SimpleTask task = new SimpleTask();
            // we create a new Thread and as the first argument we
            // need to but our Tasks
            // a task always needs to implement the runnable interface with the run method
            Thread thread = new Thread(task);

            // we can set the names of our Threads
            // here we simple use the number of the current index in this loop
            thread.setName(String.valueOf(i));

            // only when we call the start method on the Thread object
            // the thread will start its task
            thread.start();

            // we add them to our list so that we can demonstrate the threads in the stdout
            threads.add(thread);
        }

        int running; // our currrently running threads
        int lastRunning = 0; // running threads from the last iteration
        do {
            running = 0;
            for (Thread thread : threads) { // we iterate over every Thread in thread
                if (thread.isAlive()) { // we can check if the thread is alive
                    running++; // if alive we increment running
                }
            }
            if (lastRunning != running) { // if the last running threads from our last iteration is unequal the current running threads
                System.out.println("We have " + running + " running Threads");    // print to stdout
            }
            lastRunning = running;
        } while (running > 0); // if running is not 0 we repeat this process...
    }
}
