package com.practice.java8stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTerminator {
    public static String getLongestString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparing(String::length))
                .get();
    }

    public static int sumInteger(List<Integer> integers) {
        return integers.stream()
                .reduce(0, (sum, next) -> sum + next);
    }

    public static boolean haveLessThanGivenLengthWord(List<String> strings, int length) {
        return strings.stream()
                .anyMatch(s -> s.length() < length);
    }

    public static Integer[] convertListToArray(List<Integer> integers) {
        return integers.stream()
                .toArray(Integer[]::new);
    }

    public static LinkedList<Integer> convertIntegerListToLinkedList(ArrayList<Integer> integers) {
        return integers.stream()
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public static Map<Boolean, List<String>> divideStringsByLength(List<String> strings, int lessThanLength) {
        return strings.stream()
                .collect(Collectors.partitioningBy(s -> s.length() < lessThanLength));
    }

    public static Map<Integer, List<String>> groupStringsByLength(List<String> strings) {
        return strings.stream()
                .collect(Collectors.groupingBy(s -> s.length()));
    }
}
