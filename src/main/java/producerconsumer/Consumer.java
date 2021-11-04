package producerconsumer;

public class Consumer implements Runnable {
    // consumer will use the same MessageService instance (object) as the producer
    private MessageService messageService;

    public Consumer(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void run() {
        // the consumer calls get message and when the message is empty it will wait
        // when the message is not empty it will read the message return it (usually we will perform some kind of operation or task)
        // then we will set is empty to true notify all other threads that we are finished with the messages
        for (String message = messageService.getMessage(); !message.equals("DONE"); message = messageService.getMessage()) {
            // this forloop loops as long as the message is unequal DONE
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                // then we sleep for a random time between 0,5 and 2 seconds
                // to simulate the task
                // is needs to be random, so that the producer try to create a new message before
                // the consumer is done with the current one
                // but we will need to make the producer wait (see MessageService setMessage)
                Thread.sleep((int) (Math.random() * 500 + 5_000));
            } catch (InterruptedException e) {}
        }
    }
}
