package io.jeffrey.core.sortings;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.*;
import java.util.concurrent.*;

import static io.jeffrey.core.sortings.Quicksort.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTests {

    private int[] generateRandom() {
        Random random = new Random();
        int [] randomInt = new int[random.nextInt(50 + 1)];
        for (int i=0; i<randomInt.length; i++) {
            randomInt[i] = random.nextInt(20 + 1);
        }
        return randomInt;
    }

    @Test
    public void test1() {
        int [] input = new int[] {};
        int [] expected = Arrays.copyOf(input, input.length);
        execute(input);
        Arrays.sort(expected);
        assertEquals(
                Arrays.toString(expected),
                Arrays.toString(input)
        );
    }

    @Test
    public void test2() {
        int [] input = new int[] {10, 10, 10, 10, 10};
        int [] expected = Arrays.copyOf(input, input.length);
        execute(input);
        Arrays.sort(expected);
        assertEquals(
                Arrays.toString(expected),
                Arrays.toString(input)
        );
    }

    @Test
    public void test3() {
        int [] input = new int[] {11, 12, 11, 14, 2, 19, 17, 4, 12, 19};
        int [] expected = Arrays.copyOf(input, input.length);
        execute(input);
        Arrays.sort(expected);
        assertEquals(
                Arrays.toString(expected),
                Arrays.toString(input)
        );
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void test4() throws Exception {
        final int TASK_COUNT = 100;
        final int THREAD_POOL_SIZE = 20;

        final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        final List<Callable<Void>> callables = new LinkedList<>();

        for (int j=0; j<TASK_COUNT; j++) {
            callables.add(() -> {
                int [] input = generateRandom();
                int [] expected = Arrays.copyOf(input, input.length);

                long startTime = System.nanoTime();
                execute(input);
                long timeInMs = (System.nanoTime() - startTime);;
//                System.out.println("DONE: " + timeInMs + "ns " + Thread.currentThread().getName());

                Arrays.sort(expected);
                assertEquals(
                        Arrays.toString(expected),
                        Arrays.toString(input)
                );

                return null;
            });
        }

        Collection<Future<Void>> futures = executorService.invokeAll(callables);
        for (Future<Void> future : futures) {
            future.get();
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(1);
        }
        executorService.shutdownNow();
    }

}
