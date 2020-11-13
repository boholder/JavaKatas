package com.practice.java8stream;

import org.junit.Test;

import java.util.List;

import static com.practice.java8stream.StreamConvertor.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;


public class StreamConvertorTests {
    @Test
    public void stringShouldBeUppercase() {
        List<String> collection = asList("My", "name", "is", "John");
        List<String> expected = asList("MY", "NAME", "IS", "JOHN");
        assertEquals(expected, makeStringsToUpperCase(collection));
    }

    @Test
    public void makeStringLengthList() {
        List<String> collection = asList("My", "name", "is", "John");
        List<Integer> expected = asList(2, 4, 2, 4);
        assertEquals(expected, generateStringLengthList(collection));
    }

    @Test
    public void filterWillGetStringLessThan4() {
        List<String> collection = asList("My", "name", "is", "John");
        List<String> expected = asList("My", "is");
        assertEquals(expected, filterStringByLength(collection, 4));
    }

    @Test
    public void flatmapStringList() {
        List<List<String>> collection = asList(asList("a"), asList("b"));
        List<String> expected = asList("a", "b");
        assertEquals(expected, flatmapMultidimensionalList(collection));
    }

    @Test
    public void shortStringShouldBeAhead() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("My", "is", "Doe", "name", "John");
        assertEquals(expected, sortStringListByLength(collection));
    }

    @Test
    public void removeDuplicateString() {
        List<String> collection = asList("one", "one", "two");
        List<String> expected = asList("one", "two");
        assertEquals(expected, distinctStringList(collection));
    }
}
