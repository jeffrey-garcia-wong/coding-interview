package io.jeffrey.core.sortings;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.*;
import java.util.concurrent.*;

import static io.jeffrey.core.sortings.QuickSort.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTests {

    @Test
    public void empty_input_test() {
        int[] input = {};
        int[] expected = {};
        assertEquals(Arrays.toString(expected), Arrays.toString(input));
    }

    @Test
    public void small_input_sorted() {
        int[] input = {7,10};
        int[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);
        execute(input);
        assertEquals(Arrays.toString(expected), Arrays.toString(input));
    }

    @Test
    public void small_input_reversed() {
        int[] input = {3, 2, 1};
        int[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);
        execute(input);
        assertEquals(Arrays.toString(expected), Arrays.toString(input));
    }

    @Test
    public void small_identical_input() {
        int[] input = {1, 1, 1};
        int[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);
        execute(input);
        assertEquals(Arrays.toString(expected), Arrays.toString(input));
    }

    @Test
    public void medium_random_input() {
        int[] input = {10, 6, 7, 99, -1, 0, 3, 4};
        int[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);
        execute(input);
        assertEquals(Arrays.toString(expected), Arrays.toString(input));
    }

    @Test
    public void medium_random_input_2() {
        int [] input = new int[] {11, 12, 11, 14, 19, 2, 17, 4, 12, 19};
        int [] expected = Arrays.copyOf(input, input.length);
        execute(input);
        Arrays.sort(expected);
        assertEquals(
                Arrays.toString(expected),
                Arrays.toString(input)
        );
    }

    private int[] generateRandom() {
        Random r = new Random();
        int[] input = new int[r.nextInt(50 + 1)];
        for (int i=0; i<input.length; i++) {
            input[i] = r.nextInt(20 + 1);
        }
        return input;
    }

    @Execution(ExecutionMode.CONCURRENT)
    @RepeatedTest(100)
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void repeat_random_input_concurrent() {
        int[] input = generateRandom();
        int[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);
        execute(input);
        assertEquals(
                Arrays.toString(expected),
                Arrays.toString(input)
        );
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void random_input_concurrent_with_executor() throws Exception {
        final int TASK_SIZE = 100;
        final int THREAD_POOL_SIZE = 20;

        final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        final List<Callable<Void>> callables = new LinkedList<>();

        for (int i=0; i<TASK_SIZE; i++) {
            callables.add(() -> {
                int[] input = generateRandom();
                int[] expected = Arrays.copyOf(input, input.length);
                Arrays.sort(expected);
                execute(input);
                assertEquals(
                        Arrays.toString(expected),
                        Arrays.toString(input)
                );
                return null;
            });
        }

        Collection<Future<Void>> futures = executorService.invokeAll(callables);
        for (Future<Void> future : futures) future.get();

        executorService.shutdown();
        while (!executorService.isShutdown()) {
            Thread.sleep(1);
        }
        executorService.shutdownNow();
    }

}
