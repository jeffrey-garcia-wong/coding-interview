package io.jeffrey.core.lambdas;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ListsUtil {
    INSTANCE;

    public List<Integer> createList(Integer[] input) {
        return Arrays.asList(input);
    }

    public List<Integer> filterOddValues(List<Integer> list) {
        return list.stream().filter(val -> {
            return ((Integer)val & 1) != 0;
        }).collect(Collectors.toList());
    }

    public List<Integer> filterEvenValues(List<Integer> list) {
        return list.stream().filter(val -> {
            return ((Integer)val & 1) == 0;
        }).collect(Collectors.toList());
    }

    public List<Integer> mergeTwoLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> output = new LinkedList<>();
        output.addAll(
                Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList())
        );
        return output;
    }

    public List<Integer> sortListByIntegerValue(List<Integer> list) {
        Collections.sort(list, Integer::compare);
        return list;
    }

    public List<Double> transformIntegerToDouble(List<Integer> list) {
        return list.stream().map(val -> {
            return Double.valueOf(val);
        }).collect(Collectors.toList());
    }

    public Map<Integer, Double> transformListToMap(List<Integer> list) {
        return list.stream().collect(
                Collectors.toMap(val -> val, val -> Double.valueOf(val))
        );
    }

    public double aggregateOddValuesToDouble(List<Integer> list) {
        return list.stream().map(val -> Double.valueOf(val)).reduce(0d, (sum, val) -> {
            return ((val % 2d) != 0) ? sum+=val : sum;
        });
    }

    public double aggregateEvenValuesToDouble(List<Integer> list) {
        return list.stream().map(val -> Double.valueOf(val)).reduce(0d, (sum, val) -> {
            return ((val % 2d) == 0) ? sum+=val : sum;
        });
    }

    public Map<Integer, List<Integer>> groupValuesDivisibleByTwo(List<Integer> list) {
        return list.stream().collect(Collectors.groupingBy(val -> {
            return (val & 1) == 0 ? 0 : 1;
        }));
    }

    public Map<Integer, Long> groupValuesDivisibleByTwoThenCount(List<Integer> list) {
        return list.stream().collect(
                Collectors.groupingBy(
                    val -> {return (val & 1) == 0 ? 0 : 1;},
                    Collectors.counting()
                )
        );
    }
}
