package com.practice.word_wrap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.practice.word_wrap.Wrapper1.wrap;
import static org.junit.Assert.assertEquals;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ParameterizedTest1.TryParameterizedTest.class})
public class ParameterizedTest1 {

    @RunWith(Parameterized.class)
    public static class TryParameterizedTest {
        //  Using parameterized test methods (imported in junit4)
        //  CANNOT reduce code lines, and there will be less readable info.

        // Running this test you will get 2 failures,
        // 2 test sets both not passed array[0],
        // it will be constructed as last parameters constructor: {"", 1, "2"}
        private String s;
        private int col;
        private String result;

        // Constructor
        public TryParameterizedTest(String s, int col, String result) {
            this.s = s;
            this.col = col;
            this.result = result;
        }

        // This methods will be covered by input2()
        @Parameterized.Parameters
        public static Collection input() {
            return Arrays.asList(new Object[][]{
                    {"", 1, "1"},
                    {"word", 10, "word"}
            });
        }

        @Parameterized.Parameters
        public static Collection input2() {
            return Arrays.asList(new Object[][]{
                    {"", 1, "2"},
                    {"word", 10, "word"}
            });
        }

        @Test
        public void TestSet1() {
            assertEquals(result, wrap(s, col));
        }

        @Test
        public void TestSet2() {
            assertEquals(result, wrap(s, col));
        }
    }

}
