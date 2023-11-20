package com.example.threads.callables;

import java.util.concurrent.Callable;

public class TaskWithReturn implements Callable {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello World, I can return something from another thread";
    }
}
