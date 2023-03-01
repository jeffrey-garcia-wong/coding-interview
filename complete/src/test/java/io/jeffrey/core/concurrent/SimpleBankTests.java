package io.jeffrey.core.concurrent;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankTests {

    @RepeatedTest(500)
    @Execution(ExecutionMode.CONCURRENT)
    public void verifySimultaneousWithdrawAndDepositOfSameAccount() throws Exception {
        final int CORES = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(CORES);

        SimpleBank bank = new SimpleBank();

        List<Callable<Void>> callables = new LinkedList<>();
        for (int i=0; i<100; i++) {
            if ((i & 1) != 0) {
                callables.add(() -> {
                    bank.withdraw(1, 1f);
                    return null;
                });
            } else {
                callables.add(() -> {
                    bank.deposit(1, 1f);
                    return null;
                });
            }
        }

        List<Future<Void>> futures = executorService.invokeAll(callables);
        for (Future<Void> future : futures) {
            future.get();
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(1);
        }
        executorService.shutdownNow();

        assertEquals(100 , bank.balanceInquiry(1));
    }

    @RepeatedTest(500)
    @Execution(ExecutionMode.CONCURRENT)
    public void verifySimultaneousTransfer() throws Exception {
        final int CORES = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(CORES);

        SimpleBank bank = new SimpleBank();

        List<Callable<Void>> callables = new LinkedList<>();
        for (int i=0; i<100; i++) {
            callables.add(() -> {
                bank.transfer(1,2, 1);
                return null;
            });
        }

        List<Future<Void>> futures = executorService.invokeAll(callables);
        for (Future<Void> future : futures) {
            future.get();
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(1);
        }
        executorService.shutdownNow();

        assertEquals(0f, bank.balanceInquiry(1));
        assertEquals(200f, bank.balanceInquiry(2));
    }

    @RepeatedTest(500)
    @Execution(ExecutionMode.CONCURRENT)
    public void verifySimultaneousWithdrawSameAccount() throws Exception {
        final int CORES = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(CORES);

        SimpleBank bank = new SimpleBank();

        List<Callable<Float>> callables = new LinkedList<>();
        for (int i=0; i<100; i++) {
            callables.add(() -> {
                return bank.withdraw(1, 1);
            });
        }

        List<Future<Float>> futures = executorService.invokeAll(callables);
        for (Future<Float> future:futures) {
            future.get();
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(1);
        }
        executorService.shutdownNow();

        assertEquals(0f, bank.balanceInquiry(1));
    }

    @RepeatedTest(500)
    @Execution(ExecutionMode.CONCURRENT)
    public void verifySimultaneousDepositSameAccount() throws Exception {
        final int CORES = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(CORES);

        SimpleBank bank = new SimpleBank();

        List<Callable<Float>> callables = new LinkedList<>();
        for (int i=0; i<100; i++) {
            callables.add(() -> {
                return bank.deposit(1, 1);
            });
        }

        List<Future<Float>> futures = executorService.invokeAll(callables);
        for (Future<Float> future:futures) {
            future.get();
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(1);
        }
        executorService.shutdownNow();

        assertEquals(200f, bank.balanceInquiry(1));
    }

    @RepeatedTest(500)
    @Execution(ExecutionMode.CONCURRENT)
    public void verifySimultaneousWithdrawAndDepositDifferentAccount() throws Exception {
        final int CORES = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(CORES);

        SimpleBank bank = new SimpleBank();

        List<Callable<Float>> callables = new LinkedList<>();
        for (int i=0; i<100; i++) {
            if ((i & 1) != 0) {
                callables.add(() -> {
                    return bank.withdraw(1, 1);
                });
            } else {
                callables.add(() -> {
                    return bank.deposit(2, 1);
                });
            }
        }

        List<Future<Float>> futures = executorService.invokeAll(callables);
        for (Future<Float> future : futures) {
            future.get();
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(1);
        }
        executorService.shutdownNow();

        assertEquals(50f, bank.balanceInquiry(1));
        assertEquals(150f, bank.balanceInquiry(2));
    }

    @RepeatedTest(500)
    @Execution(ExecutionMode.CONCURRENT)
    public void verifySimultaneousTransferAndWithdraw() throws Exception {
        final int CORES = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(CORES);

        SimpleBank bank = new SimpleBank();

        List<Callable<Void>> callables = new LinkedList<>();
        for (int i=0; i<100; i++) {
            if ((i & 1) != 0) {
                callables.add(() -> {
                    bank.transfer(1,2, 1);
                    return null;
                });
            } else {
                callables.add(() -> {
                    bank.withdraw(1, 1);
                    return null;
                });
            }
        }

        List<Future<Void>> futures = executorService.invokeAll(callables);
        for (Future<Void> future : futures) {
            future.get();
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(1);
        }
        executorService.shutdownNow();

        assertEquals(0f, bank.balanceInquiry(1));
        assertEquals(150f, bank.balanceInquiry(2));
    }

    @RepeatedTest(500)
    @Execution(ExecutionMode.CONCURRENT)
    public void verifySimultaneousTransferAndDeposit() throws Exception {
        final int CORES = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(CORES);

        SimpleBank bank = new SimpleBank();

        List<Callable<Void>> callables = new LinkedList<>();
        for (int i=0; i<100; i++) {
            if ((i & 1) != 0) {
                callables.add(() -> {
                    bank.transfer(1,2, 1);
                    return null;
                });
            } else {
                callables.add(() -> {
                    bank.deposit(1, 1);
                    return null;
                });
            }
        }

        List<Future<Void>> futures = executorService.invokeAll(callables);
        for (Future<Void> future : futures) {
            future.get();
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(1);
        }
        executorService.shutdownNow();

        assertEquals(100f, bank.balanceInquiry(1));
        assertEquals(150f, bank.balanceInquiry(2));
    }

}
