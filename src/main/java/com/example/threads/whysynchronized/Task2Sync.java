package com.example.threads.whysynchronized;

public class Task2Sync implements Runnable {
    private Table table;

    public Task2Sync(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        // here we use the method with the synchronized keyword
        table.printTableSync(100);
    }
}
