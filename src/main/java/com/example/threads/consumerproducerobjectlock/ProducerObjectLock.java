package com.example.threads.consumerproducerobjectlock;

public class ProducerObjectLock implements Runnable {
    MessageServiceObjectLock messageServiceObjectLock;

    public ProducerObjectLock(MessageServiceObjectLock messageServiceObjectLock) {
        this.messageServiceObjectLock = messageServiceObjectLock;
    }

    @Override
    public void run() {
        String importantInfo[] = {
                "Message 1",
                "Message 2",
                "Message 3",
                "Message 4",
        };

        // for the length of the message array we will loop
        for (int i = 0; i < importantInfo.length; i++) {
            // then we set the message to the element with the current index of the loop in our array
            messageServiceObjectLock.setMessage(importantInfo[i]);
            try {
                // then we sleep
                // here it could be that the producer tries to create a message before the consumer is done
                // or the consumer tries to consume a new message before the producer has a new message
                // we need to ensure that both scenarios do not happen
                // see Message Service getMessage and setMessage where we use guarded blocks to let the producer or the consumer wait
                Thread.sleep((int) (Math.random() * 500 + 2_000));
            } catch (InterruptedException e) {}
        }
        messageServiceObjectLock.setMessage("DONE");
    }
}
