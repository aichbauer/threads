package completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class CompleteableFutures {
    public static void main(String[] args) {
        // we instantiate the new task
        Task task = new Task();
        // we call the future on our object
        CompletableFuture<String> myfuture = task.calculate("input").thenApply((result) -> {
            // we can use thenApply to chain async operations that will use the result from the previous task
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // this will be input the result of our completable future
            return result + " AND THE FUTURE AFTER THE FUTURE ;P";
        });

        // this will be printed first because the future is not yet done and runs in a seperate thread
        System.out.println("HELLO FROM THE PRESENT :P");

        // I could cancel the future
        // myfuture.cancel();
        // I could check if the future is done or not
        // myfuture.isDone();

        try {
            // .get() will block the current thread
            // but we could do something else by checking isDone()
            // this will print the result of our completeable future
            System.out.println(myfuture.get());
            // this will be printed after the completable future is resolved
            System.out.println(".get() BLOCKS THE MAIN THREAD, I WILL PRINT AFTER THE COMPLETABLE FUTURE IS RESOLVED");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
