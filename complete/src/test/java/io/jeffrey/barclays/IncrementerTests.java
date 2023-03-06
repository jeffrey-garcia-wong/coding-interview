package io.jeffrey.barclays;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncrementerTests {

    @Test
    public void verify_count_is_1000_with_eight_threads() throws ExecutionException, InterruptedException {
        final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(8);
        final Lock lock = new ReentrantLock();

        for (int i=0; i<5000; i++) {
            Callable<Void> callable = () -> {
                new Incrementer(lock).run();
                return null;
            };

            final List<Callable<Void>> callables = new LinkedList<>();
            callables.add(callable);
            callables.add(callable);
            callables.add(callable);
            callables.add(callable);
            callables.add(callable);
            callables.add(callable);
            callables.add(callable);
            callables.add(callable);

            Collection<Future<Void>> futures = executorService.invokeAll(callables);
            for (Future<Void> future : futures) {
                future.get();
            }

            assertEquals(400, Incrementer.counter);
            Incrementer.counter = 0;
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(1);
        }
        executorService.shutdownNow();
    }

}
