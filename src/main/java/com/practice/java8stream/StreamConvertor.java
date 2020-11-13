package com.practice.java8stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamConvertor {
    public static List<String> makeStringsToUpperCase(List<String> strings) {
        return strings.stream() // Convert collection to Stream
                .map(String::toUpperCase) // Convert each element to upper case
                .collect(Collectors.toList()); // Collect results to a new list
    }

    public static List<Integer> generateStringLengthList(List<String> strings) {
        return strings.stream()
                .mapToInt(String::length).boxed()
                .collect(Collectors.toList());
    }

    public static List<String> filterStringByLength(List<String> strings, int length) {
        return strings.stream()
                .filter(s -> s.length() < length)
                .collect(Collectors.toList());
    }

    public static List<String> flatmapMultidimensionalList(List<List<String>> stringLists) {
        return stringLists.stream() // Convert collection to Stream
                .flatMap(list -> list.stream()) // Replace list with stream
                .collect(Collectors.toList()); // Collect results to a new list
    }

    public static List<String> sortStringListByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> distinctStringList(List<String> strings) {
        return strings.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
