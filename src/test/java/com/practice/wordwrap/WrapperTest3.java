package com.practice.wordwrap;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static com.practice.wordwrap.Wrapper3.wrap;
import static org.junit.Assert.assertEquals;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        WrapperTest3.DegenerateTests.class,
        WrapperTest3.SplitWordTests.class})

public class WrapperTest3 {
    // Test class should have exactly one public constructor
    public static class DegenerateTests {
        @Test
        public void wrapEmptyStringShouldBeEmpty() {
            assertEquals("", wrap("", 1));
        }

        @Test
        public void stringShorterThanColDoesNotWrap() {
            assertEquals("word", wrap("word", 10));
        }
    }

    public static class SplitWordTests {
        @Test
        public void splitOneWord() {
            assertEquals("wo\nrd", wrap("word", 2));
        }

        // new, split one string which has no space character, many times
        @Test
        public void splitOneWordManyTimes() {
            assertEquals("abc\ndef\nghi\nj", wrap("abcdefghij", 3));
        }
    }
}