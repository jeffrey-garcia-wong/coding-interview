package com.jeffrey.core.maths;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.fail;

public class PrimeNumbersTests {

    private void check(Set<Integer> resultSet, List<Integer> primes) {
        if (resultSet.size() != primes.size())
            fail("primes size un-match!");

        for (Integer prime:primes) {
            if (!resultSet.contains(prime)) {
                fail("invalid prime: " + prime);
            }
            resultSet.remove(prime);
        }

        if (resultSet.size() > 0) {
            fail("missing prime from output");
        }
    }

    @Test
    public void test_001() {
        Set<Integer> resultSet = new HashSet<>();
        List<Integer> primes = PrimeNumbers.execute(1);
        check(resultSet, primes);
    }

    @Test
    public void test_002() {
        Set<Integer> resultSet = new HashSet<>();
        resultSet.add(2);
        resultSet.add(3);
        resultSet.add(5);
        resultSet.add(7);
        resultSet.add(11);
        List<Integer> primes = PrimeNumbers.execute(11);
        check(resultSet, primes);
    }

    @Test
    public void test_003() {
        Set<Integer> resultSet = new HashSet<>();
        resultSet.add(2);
        resultSet.add(3);
        resultSet.add(5);
        resultSet.add(7);
        resultSet.add(11);
        resultSet.add(13);
        List<Integer> primes = PrimeNumbers.execute(15);
        check(resultSet, primes);
    }

}
