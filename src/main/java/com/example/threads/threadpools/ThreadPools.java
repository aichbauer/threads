package com.example.threads.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPools {

    public static void main(String[] args) {
        try {
            // Create a Thread Pool
            // this will only execute 5 concurrent threads at a time
            // even if we give the Executor 500 tasks
            ExecutorService executor = Executors.newFixedThreadPool(5);

            // we iterate and create 500 tasks
            // and tell the executor to excute them
            // only 5 at a time
            for (int i = 0; i < 500; i++) {
                Runnable task = new SimpleTask2();
                executor.execute(task);
            }

            // count the currently active threads
            int count = Thread.activeCount();
            System.out.println("currently active threads = " + count);

            // This will make the executor accept no new threads
            // and finish all existing threads in the queue
            executor.shutdown();
            try {
                executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("Finished all threads");
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
