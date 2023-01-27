package io.jeffrey.core.search;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.*;
import java.util.concurrent.*;

import static io.jeffrey.core.search.BinarySearch.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTests {

    private static class RandomInput {
        int[] array;
        int target;
        RandomInput(int[] array, int target) {
            this.array = array;
            this.target = target;
        }
    }

    private RandomInput generateRandom() {
        Random random = new Random();
        int [] randomInt = new int[random.nextInt(100 + 1)];
        for (int i=0; i<randomInt.length; i++) {
            randomInt[i] = random.nextInt(20 + 1);
        }
        return new RandomInput(randomInt, random.nextInt(20 + 1));
    }

    @Test
    public void search_small_input() {
        int[] input = {3, 2, 1};
        Arrays.sort(input);
        assertEquals(1, execute(input, 2));
    }

    @Test
    public void search_small_input_not_found() {
        int[] input = {6,2,4};
        Arrays.sort(input);
        assertEquals(
                Arrays.binarySearch(input, 3),
                execute(input, 3));
    }

    @Test
    public void search_medium_input() {
        int[] input = {10, 4, -7, 99, 2, 34, 28, 0, 55};
        Arrays.sort(input);
        assertEquals(6, execute(input, 34));
    }

    @RepeatedTest(100)
    @Execution(ExecutionMode.CONCURRENT)
    public void repeat_random_100_times_concurrently() {
        RandomInput r = generateRandom();
        int[] input = r.array;
        int target = r.target;
        Arrays.sort(input);
        assertEquals(
                Arrays.binarySearch(input, target),
                execute(input, target)
        );
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void repeat_random_100_times_concurrently_with_executors() throws Exception {
        final int TASK_COUNT = 100;
        final int THREAD_POOL_SIZE = 20;

        final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        final List<Callable<Void>> callables = new LinkedList<>();

        for (int j=0; j<TASK_COUNT; j++) {
            callables.add(() -> {
                RandomInput r = generateRandom();
                int[] input = r.array;
                int target = r.target;
                Arrays.sort(input);
                assertEquals(
                        Arrays.binarySearch(input, target),
                        execute(input, target)
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
