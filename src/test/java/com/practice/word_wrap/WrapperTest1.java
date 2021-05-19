package com.practice.word_wrap;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static com.practice.word_wrap.Wrapper1.wrap;
import static org.junit.Assert.assertEquals;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        WrapperTest1.DegenerateTests.class})
public class WrapperTest1 {
    // new cases, input string is too short to be split
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
}