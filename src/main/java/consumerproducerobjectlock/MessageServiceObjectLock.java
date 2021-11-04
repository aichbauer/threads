package consumerproducerobjectlock;

public class MessageServiceObjectLock {
    // every object in java has its own lock
    // so, we can simply use another object to lock
    // methods with a synchronized block
    // usually we use this method or the reentrant lock when we need more than one lock on an object
    private Object lock = new Object();
    // usually we would use a que to check weather the message que is empty or not
    // we simplify it to just use a single message at a time
    private String message = "";


    public String getMessage() {
        // with synchronized we lock all threads from entering this block before
        // the current thread is finished with it
        // instead of the lock variable which is a new Object
        // we could also use this and use the lock of this object itself
        synchronized (lock) {
            System.out.println("Track the consumer: " + 1);
            // guarded block
            // when the message is empty the consumer must wait
            // everytime this.notifyAll() is called this will loop again
            // and if the message is not empty it will break out the loop
            while(this.message.isEmpty()) {
                try {
                    System.out.println("Track the consumer: " + 2);

                    // we need to use the wait method on our lock
                    lock.wait();
                } catch (InterruptedException e) {}
            }
            System.out.println("Track the consumer: " + 3);

            // use a temporary variable to return and clear the message
            String tempMessage = this.message;
            // clear the message
            this.message = "";
            // notify all other threads that use the same lock
            // if we use "this" in the synchronized statement we would need to call the notifyAll method on "this" object
            // here we call the notifyAll method of our lock
            lock.notifyAll();
            // return the message
            return tempMessage;
        }

        // we could only synchronize some parts of a function
    }

    // with synchronized we lock all threads from entering this message before
    // the current thread is finished with it
    public void setMessage(String message) {
        // with synchronized we lock all threads from entering this block before
        // the current thread is finished with it
        // instead of the lock variable which is a new Object
        // we could also use this and use the lock of this object itself
        synchronized (lock) {
            System.out.println("Track the producer: " + 1);
            // guarded block
            // when the message is not empty the producer must wait
            // everytime this.notifyAll() is called this will loop again
            // and if the message is empty it will break out the loop
            while (!this.message.isEmpty()) {
                try {
                    System.out.println("Track the producer: " + 2);

                    // we need to use the wait method on our lock
                    lock.wait();
                } catch (InterruptedException e) {}
            }
            System.out.println("Track the producer: " + 3);

            // set the message to the that the producer sends to this method
            this.message = message;
            // when the message is set notify all other threads that
            // if we use "this" in the synchronized statement we would need to call the notifyAll method on "this" object
            // here we call the notifyAll method of our lock
            lock.notifyAll();
        }

        // we could only synchronize some parts of a function
    }
}
