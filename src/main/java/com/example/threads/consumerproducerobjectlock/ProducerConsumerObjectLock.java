package com.example.threads.consumerproducerobjectlock;

public class ProducerConsumerObjectLock {
    public static void main(String[] args) {
        MessageServiceObjectLock messageServiceObjectLock = new MessageServiceObjectLock();
        ProducerObjectLock task1 = new ProducerObjectLock(messageServiceObjectLock);
        ConsumerObjectLock task2 = new ConsumerObjectLock(messageServiceObjectLock);
        new Thread(task1).start();
        new Thread(task2).start();
    }
}
