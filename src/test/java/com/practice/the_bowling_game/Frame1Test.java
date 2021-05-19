package com.practice.the_bowling_game;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Frame1 Tester.
 */
public class Frame1Test {

    @Test
    public void testScoreNoThrows() {
        Frame1 f = new Frame1();
        assertThat(0, Matchers.is(f.getScore()));
    }
} 
