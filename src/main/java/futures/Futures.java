package futures;

import java.util.concurrent.Future;

public class Futures {
    public static void main(String[] args) {
        // we instantiate the new task
        Task task = new Task();
        // we call the future on our object
        Future<Integer> myfuture = task.calculate(20);
        try {
            // while the future is not done
            // we can do something else
            while (!myfuture.isDone()) {
                System.out.println("Do something else");
            }
            // .get() will block the current thread
            // but we could do something else by checking isDone()
            System.out.println(myfuture.get());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
