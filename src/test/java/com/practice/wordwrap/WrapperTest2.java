package com.practice.wordwrap;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static com.practice.wordwrap.Wrapper2.wrap;
import static org.junit.Assert.assertEquals;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        WrapperTest2.DegenerateTests.class,
        WrapperTest2.SplitWordTests.class})

public class WrapperTest2 {
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
        // new, split one string which has no space character, one time
        @Test
        public void splitOneWord() {
            Assert.assertEquals("wo\nrd", wrap("word", 2));
        }
    }
}