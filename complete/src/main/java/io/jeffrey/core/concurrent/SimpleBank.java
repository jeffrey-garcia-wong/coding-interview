package io.jeffrey.core.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <h1>Simple Bank</h1>
 *
 * A simple bank app supporting concurrent transaction.<p/>
 *
 * This class is unconditionally thread-safe. Instances of
 * this class contain mutable data, but the class has sufficient
 * internal synchronization that its instances can be used
 * concurrently without the need of external synchronization.<p/>
 */
public class SimpleBank {
    private final Lock lock = new ReentrantLock();
    private final Map<Integer, Float> accountBalance = new HashMap<>();

    public SimpleBank() {
        for (int i=1; i<=10; i++) {
            accountBalance.putIfAbsent(i, 100f);
        }
    }

    public void transfer(int srcAccountNumber, int destAccountNumber, float amount) {
        withdraw(srcAccountNumber, amount);
        deposit(destAccountNumber, amount);
    }

    public Float withdraw(int accountNumber, float amount) {
        lock.lock();
        try {
            Float currentBalance = accountBalance.get(accountNumber);
            Objects.requireNonNull(currentBalance);
            Float newBalance = currentBalance - Float.valueOf(amount);
            accountBalance.put(accountNumber, newBalance);
            return newBalance;
        } finally {
            lock.unlock();
        }
    }

    public Float deposit(int accountNumber, float amount) {
        lock.lock();
        try {
            Float currentBalance = accountBalance.get(accountNumber);
            Objects.requireNonNull(currentBalance);
            Float newBalance = currentBalance + Float.valueOf(amount);
            accountBalance.put(accountNumber, newBalance);
            return newBalance;
        } finally {
            lock.unlock();
        }
    }

    public Float balanceInquiry(int accountNumber) {
        Float currentBalance = accountBalance.get(accountNumber);
        Objects.requireNonNull(currentBalance);
        return currentBalance;
    }

}
