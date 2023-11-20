package com.example.threads.producerconsumerreentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MessageServiceReentrantLock {
    // instead, if synchronized we use a single lock for this object
    private ReentrantLock lock = new ReentrantLock();

    // we need a condition we can wait on
    private Condition condition = lock.newCondition();

    // usually we would use a que to check weather the message que is empty or not
    // we simplify it to just use a single message at a time
    private String message = "";

    // with synchronized we lock all threads from entering this message before
    // the current thread is finished with it
    public String getMessage() {
        System.out.println("Track the consumer: " + 1);

        // no synchronize, so we lock the method at this point and keep other threads from entering this code block
        lock.lock();
        // guarded block
        // when the message is empty the consumer must wait
        // everytime this.notifyAll() is called this will loop again
        // and if the message is not empty it will break out the loop
        while(this.message.isEmpty()) {
            try {
                System.out.println("Track the consumer: " + 2);

                // we will await our condition
                // this will wait until signalAll will be called
                // similar to notifyAll on the Object itself
                condition.await();
            } catch (InterruptedException e) {}
        }
        System.out.println("Track the consumer: " + 3);
        // use a temporary variable to return and clear the message
        String tempMessage = this.message;
        // clear the message
        this.message = "";
        // notify all other threads that use the same object of this class
        condition.signalAll();
        // unlock this method so that it can be used by other threads
        lock.unlock();
        // return the message
        return tempMessage;
    }

    // with synchronized we lock all threads from entering this message before
    // the current thread is finished with it
    public void setMessage(String message) {
        System.out.println("Track the producer: " + 1);
        // no synchronize, so we lock the method at this point and keep other threads from entering this code block
        lock.lock();
        // guarded block
        // when the message is not empty the producer must wait
        // everytime this.notifyAll() is called this will loop again
        // and if the message is empty it will break out the loop
        while (!this.message.isEmpty()) {
            try {
                System.out.println("Track the producer: " + 2);
                // we will await our condition
                // this will wait until signalAll will be called
                // similar to notifyAll on the Object itself
                condition.await();
            } catch (InterruptedException e) {}
        }
        System.out.println("Track the producer: " + 3);

        // set the message to the that the producer sends to this method
        this.message = message;
        // notify all other threads that use the same object of this class
        condition.signalAll();
        // unlock this method so that it can be used by other threads
        lock.unlock();
    }
}
