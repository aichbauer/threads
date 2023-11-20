package com.example.threads.whysynchronized;

public class WhySynchronized {
    public static void main(String[] args) {
        System.out.println("NOT SYNCED:");
        // create a table
        Table table = new Table();

        // use one object for both tasks
        // so they share the same methods and state
        Task1 task1 = new Task1(table);
        Task2 task2 = new Task2(table);

        // create two threads
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        // start the threads
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // output something like (sometimes it will be in correct order, sometimes not):
        // 5 <- thread1
        // 100 <- thread2 can enter the method before thread1 finishes
        // 10 <- thread1
        // 15 <- thread1
        // 20 <- thread1
        // 25 <- thread1
        // 200 <- thread2
        // 300 <- thread2
        // 400 <- thread2
        // 500 <- thread2

        System.out.println("\n\n\nSYNCED:");
        // create a table
        Table table2 = new Table();

        // use one object for both tasks
        // so they share the same methods and state
        Task1Sync task1sync = new Task1Sync(table2);
        Task2Sync task2Sync = new Task2Sync(table2);

        // create two threads
        Thread thread3 = new Thread(task1sync);
        Thread thread4 = new Thread(task2Sync);

        // start the threads
        thread3.start();
        thread4.start();
        // output (this will always in the correct order no matter what):
        // 5 <- thread1
        // 10 <- thread1
        // 15 <- thread1
        // 20 <- thread1
        // 25 <- thread1
        // 100 <- thread2 can enter only enter the method after thread 1 is finished
        // 200 <- thread2
        // 300 <- thread2
        // 400 <- thread2
        // 500 <- thread2
    }
}
