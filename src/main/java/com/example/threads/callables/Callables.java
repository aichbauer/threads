package com.example.threads.callables;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Callables {
    public static void main(String[] args) {
        // we need an executor that we can pass our callable
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // we create an instance of our task which implements the callable
        // which will return an result
        TaskWithReturn taskWithReturn = new TaskWithReturn();
        // here we say that the value of our future will be a string
        // and our callable will be executed by our executor
        Future<String> future = executor.submit(taskWithReturn);

        try {
            // while not done
            while (!future.isDone()) {
                System.out.println("Do something else!");
            }

            // this will block the main thread... or any thread that calls the get method on the future
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
