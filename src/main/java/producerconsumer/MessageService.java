package producerconsumer;

public class MessageService {
    // usually we would use a que to check weather the message que is empty or not
    // we simplify it to just use a single message at a time
    private String message = "";

    // with synchronized we lock all threads from entering this message before
    // the current thread is finished with it
    public synchronized String getMessage() {
        System.out.println("Track the consumer: " + 1);
        // guarded block
        // when the message is empty the consumer must wait
        // everytime this.notifyAll() is called this will loop again
        // and if the message is not empty it will break out the loop
        while(this.message.isEmpty()) {
            try {
                System.out.println("Track the consumer: " + 2);

                this.wait();
            } catch (InterruptedException e) {}
        }
        System.out.println("Track the consumer: " + 3);

        // use a temporary variable to return and clear the message
        String tempMessage = this.message;
        // clear the message
        this.message = "";
        // notify all other threads that use the same object of this class
        this.notifyAll();
        // return the message
        return tempMessage;
    }

    // with synchronized we lock all threads from entering this message before
    // the current thread is finished with it
    public synchronized void setMessage(String message) {
        System.out.println("Track the producer: " + 1);
        // guarded block
        // when the message is not empty the producer must wait
        // everytime this.notifyAll() is called this will loop again
        // and if the message is empty it will break out the loop
        while (!this.message.isEmpty()) {
            try {
                System.out.println("Track the producer: " + 2);

                this.wait();
            } catch (InterruptedException e) {}
        }
        System.out.println("Track the producer: " + 3);

        // set the message to the that the producer sends to this method
        this.message = message;
        // when the message is set notify all other threads that
        this.notifyAll();
    }
}
