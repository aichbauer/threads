package com.example.threads.whysynchronized;

public class Task2 implements Runnable {
    private Table table;

    public Task2(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        // here we use the method WITHOUT the synchronized keyword
        table.printTable(100);
    }
}
