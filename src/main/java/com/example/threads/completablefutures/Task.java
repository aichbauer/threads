package com.example.threads.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task {
    // we need an executor for our future
    // here we use a single thread executor
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    // we define our return value as a Future
    // with the data type the future will return
    public CompletableFuture<String> calculate(String input) {
        // we use the executor to submit a task
        // we use the lambda syntax
        return CompletableFuture.supplyAsync(() -> {
            try {
                // we will wait to simulate async tasks
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("HELLO FROM THE FUTURE");
           return "input";
        }, executor);
    }
}
