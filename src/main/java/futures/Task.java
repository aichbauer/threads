package futures;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task {
    // we need an executor for our future
    // here we use a single thread executor
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    // we define our return value as a Future
    // with the data type the future will return
    public Future<Integer> calculate(Integer input) {
        // we use the executor to submit a task
        // we use the lambda syntax
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }
}
