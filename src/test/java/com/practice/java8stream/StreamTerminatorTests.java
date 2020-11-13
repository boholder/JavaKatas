package com.practice.java8stream;

import org.junit.Test;

import java.util.*;

import static com.practice.java8stream.StreamTerminator.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class StreamTerminatorTests {
    @Test
    public void returnLongestString() {
        List<String> collection = asList("one", "tow", "three");
        String expected = "three";
        assertEquals(expected, getLongestString(collection));
    }

    @Test
    public void getSumOfIntegers() {
        List<Integer> colleciton = asList(1, 2, 3);
        int expected = 6;
        assertEquals(expected, sumInteger(colleciton));
    }

    @Test
    public void judgeIfListHaveWordThatLengthLessThan4() {
        List<String> collection = asList("one", "two", "three");
        boolean expected = true;
        assertEquals(expected, haveLessThanGivenLengthWord(collection, 4));
    }

    @Test
    public void getAnArrayFromListThroughStream() {
        List<Integer> collection = asList(1, 2, 3);
        Integer[] expected = {1, 2, 3};
        assertEquals(expected, convertListToArray(collection));
    }

    @Test
    public void getLinkedListFromArrayList() {
        ArrayList<Integer> collection = new ArrayList<>(asList(1, 2, 3));
        LinkedList<Integer> expected = new LinkedList<>(asList(1, 2, 3));
        assertEquals(expected, convertIntegerListToLinkedList(collection));
    }

    @Test
    public void divideStringsToTwoGroup() {
        List<String> collection = asList("one", "two", "three");
        Map<Boolean, List<String>> expected = new HashMap<>();
        expected.put(true, asList("one", "two"));
        expected.put(false, asList("three"));
        assertEquals(expected, divideStringsByLength(collection, 4));
    }

    @Test
    public void groupStringsByLengthIntoMap() {
        List<String> collection = asList("one", "two", "three");
        Map<Integer, List<String>> expected = new HashMap<>();
        expected.put(3, asList("one", "two"));
        expected.put(5, asList("three"));
        assertEquals(expected, groupStringsByLength(collection));
    }
}
