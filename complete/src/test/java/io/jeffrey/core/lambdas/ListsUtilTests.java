package io.jeffrey.core.lambdas;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListsUtilTests {

    private Integer[] generateData(final int SIZE) {
        Integer[] input = new Integer[SIZE];
        for (int i=0; i<SIZE; i++) {
            input[i] = i;
        }
        return input;
    }

    @Test
    public void test_init_list() {
        final int SIZE = 10;
        Integer[] input = generateData(SIZE);

        List<Integer> output = ListsUtil.INSTANCE.createList(input);
        assertEquals(SIZE, output.size());
        for (int i : input) {
            assertTrue(output.stream().anyMatch(val -> val == i));
        }
    }

    @Test
    public void test_filter_odd_values() {
        final int SIZE = 10;
        Integer[] input = generateData(SIZE);

        List<Integer> output = ListsUtil.INSTANCE.filterOddValues(ListsUtil.INSTANCE.createList(input));
        assertEquals(SIZE >> 1, output.size());
        for (int i : input) {
            if ((i & 1) != 0) {
                assertEquals(1, output.stream().filter(val -> val == i).count());
            }
        }
    }

    @Test
    public void test_filter_even_values() {
        final int SIZE = 10;
        Integer[] input = generateData(SIZE);

        List<Integer> output = ListsUtil.INSTANCE.filterEvenValues(ListsUtil.INSTANCE.createList(input));
        assertEquals(SIZE >> 1, output.size());
        for (int i : input) {
            if ((i & 1) == 0) {
                assertEquals(1, output.stream().filter(val -> val == i).count());
            }
        }
    }

    @Test
    public void test_merge_two_lists() {
        final int SIZE = 10;
        Integer[] input = generateData(SIZE);

        List<Integer> listOdd = ListsUtil.INSTANCE.filterOddValues(ListsUtil.INSTANCE.createList(input));
        List<Integer> listEven = ListsUtil.INSTANCE.filterEvenValues(ListsUtil.INSTANCE.createList(input));

        List<Integer> output = ListsUtil.INSTANCE.mergeTwoLists(listOdd, listEven);
        assertEquals(SIZE, output.size());
        for (int i : input) {
            assertEquals(1, (int) output.stream().filter(val -> val == i).count());
        }
    }

    @Test
    public void test_sort_list_by_integer_values() {
        final int SIZE = 10;
        Integer[] input = generateData(SIZE);

        List<Integer> output = ListsUtil.INSTANCE.sortListByIntegerValue(ListsUtil.INSTANCE.createList(input));
        assertEquals(SIZE, output.size());
        ListIterator<Integer> iterator = output.listIterator();
        for (int i : input) {
            assertEquals(i, (int)iterator.next());
        }
    }

    @Test
    public void test_transform_list_to_double() {
        final int SIZE = 10;
        Integer[] input = generateData(SIZE);

        List<Double> output = ListsUtil.INSTANCE.transformIntegerToDouble(ListsUtil.INSTANCE.createList(input));
        assertEquals(SIZE, output.size());
        for (int i : input) {
            assertEquals(1, output.stream().filter(val -> val == (double)i).count());
        }
    }

    @Test
    public void test_transform_list_to_map() {
        final int SIZE = 10;
        Integer[] input = generateData(SIZE);

        Map<Integer, Double> output = ListsUtil.INSTANCE.transformListToMap(ListsUtil.INSTANCE.createList(input));
        assertEquals(SIZE, output.size());
        for (int i : input) {
            assertEquals((double)i, (double)output.get(i));
        }
    }

    @Test
    public void test_aggregate_odd_values() {
        final int SIZE = 10;
        Integer[] input = generateData(SIZE);

        double expected = 0d;
        for (int i : input) {
            if ((i & 1) != 0) expected += i;
        }

        double output = ListsUtil.INSTANCE.aggregateOddValuesToDouble(ListsUtil.INSTANCE.createList(input));
        assertEquals(expected, output);
    }

    @Test
    public void test_aggregate_even_values() {
        final int SIZE = 10;
        Integer[] input = generateData(SIZE);

        double expected = 0d;
        for (int i : input) {
            if ((i & 1) == 0) expected += i;
        }

        double output = ListsUtil.INSTANCE.aggregateEvenValuesToDouble(ListsUtil.INSTANCE.createList(input));
        assertEquals(expected, output);
    }

    @Test
    public void test_group_values_divisible_by_two() {
        final int SIZE = 10;
        Integer[] input = generateData(SIZE);

        Map<Integer, List<Integer>> output = ListsUtil.INSTANCE.groupValuesDivisibleByTwo(ListsUtil.INSTANCE.createList(input));
        assertEquals(2, output.size());

        for (int i : input) {
            List<Integer> list;
            if ((i & 1) != 0) {
                list = output.getOrDefault(1, new LinkedList<>());
            } else {
                list = output.getOrDefault(0, new LinkedList<>());
            }
            assertEquals(1, list.stream().filter(val -> {
                return val == i;
            }).count());
        }
    }

    @Test
    public void test_group_values_divisible_by_two_then_count() {
        final int SIZE = 10;
        Integer[] input = generateData(SIZE);

        Map<Integer, Long> output = ListsUtil.INSTANCE.groupValuesDivisibleByTwoThenCount(ListsUtil.INSTANCE.createList(input));
        long oddCount = 0L;
        long evenCount = 0L;
        for (int i : input) {
            if ((i & 1) != 0) {
                oddCount += 1;
            } else {
                evenCount += 1;
            }
        }
        assertEquals(oddCount, (long)output.get(1));
        assertEquals(evenCount, (long)output.get(0));
    }

}
