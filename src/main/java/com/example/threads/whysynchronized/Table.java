package com.example.threads.whysynchronized;

public class Table {
    // threads can enter this method whenever they want
    public void printTable(int n) {
        // simple loop to print something
        for (int i = 1; i<=5; i++) {
            // n = 1
            //     1
            //     2
            //     3
            //     4
            //     5
            System.out.println(n*i);
        }
        try {
            // wait for 400 milisecods
            Thread.sleep(400);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    // threads can only enter this method if it is not locked
    // if a thread enters this code it locks it for all other threads
    // if a thread returns from this method it will open the lock
    // and notifies the other threads
    public synchronized void printTableSync(int n) {
        // simple loop to print something
        for (int i = 1; i<=5; i++) {
            // n = 1
            //     1
            //     2
            //     3
            //     4
            //     5
            System.out.println(n*i);
        }
        try {
            // wait for 400 milisecods
            Thread.sleep(400);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
