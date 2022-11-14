package io.jeffrey.core.sortings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static io.jeffrey.core.sortings.Quicksort.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuicksortTests {

    private int[] generateRandom(int size) {
        Random random = new Random();

        int [] randomInt = new int[size];
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
    public void test4() throws InterruptedException {
        final int TASK_COUNT = 100;
        final int THREAD_POOL_SIZE = 20;
        final CountDownLatch latch = new CountDownLatch(TASK_COUNT);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int j=0; j<TASK_COUNT; j++) {
            executorService.execute(() -> {
                int SIZE = 50;
                int [] input = generateRandom(SIZE);
                int [] expected = Arrays.copyOf(input, input.length);

                long startTime = System.nanoTime();
                execute(input);
                long timeInMs = (System.nanoTime() - startTime);;
                System.out.println("DONE: " + timeInMs + "ns " + Thread.currentThread().getName());

                Arrays.sort(expected);
                assertEquals(
                        Arrays.toString(expected),
                        Arrays.toString(input)
                );

                latch.countDown();
            });
        }

        latch.await();
    }

}
