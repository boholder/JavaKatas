package com.practice.word_wrap;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static com.practice.word_wrap.Wrapper4.wrap;
import static org.junit.Assert.assertEquals;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        WrapperTest4.DegenerateTests.class,
        WrapperTest4.SplitWordTests.class,
        WrapperTest4.WrapTwoWords.class})

public class WrapperTest4 {
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

        @Test
        public void splitOneWordManyTimes() {
            assertEquals("abc\ndef\nghi\nj", wrap("abcdefghij", 3));
        }
    }

    // New, now consider strings which has space characters become input,
    // combination of line length and FIRST space position request different processes.
    // There are 3 combinations, let input be "word word", then the position of space is 5,
    // so let line length limit be 3,4,5,6,7

    // In origin article, the author broke this step into 3 steps,
    // each step consider about one position combination.
    // Plz pay attention to the consideration of boundary values in this step.
    public static class WrapTwoWords {
        // line length < space position, the diff > 1 (have to cut a word into 2 lines)
        @Test
        public void wrapWellBeforeWordBoundary() {
            assertEquals("wor\nd\nwor\nd", wrap("word word", 3));
        }

        // line length < space position, the diff is only 1
        // (not-space character length still enough, no need to split between word)
        @Test
        public void wrapJustBeforeWordBoundary() {
            assertEquals("word\nword", wrap("word word", 4));
        }

        // line length == space position, the diff is 0 (replace space with "\n")
        @Test
        public void wrapOnWordBoundary() {
            assertEquals("word\nword", wrap("word word", 5));

        }

        // line length > space position, the diff is only 1 (split on ahead space position)
        @Test
        public void wrapAfterWordBoundary() {
            assertEquals("word\nword", wrap("word word", 6));
        }

        // line length > space position, the diff > 1 (same as upper case)
        @Test
        public void wrapWellAfterWordBoundary() {
            assertEquals("word\nword", wrap("word word", 7));
        }
    }
}