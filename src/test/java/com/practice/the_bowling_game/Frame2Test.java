package com.practice.the_bowling_game;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Frame2 Tester.
 */
public class Frame2Test {

    @Test
    public void testScoreNoThrows() {
        Frame1 f = new Frame1();
        assertThat(0, Matchers.is(f.getScore()));
    }

    // new, note that f.add() accept an integer (downed pins), not a "Throw" instance,
    // before add() was actually added in Frame class.
    // Bob decided not use a "Throw" class to contain downed pins.
    @Test
    public void testAddOneThrow() {
        Frame2 f = new Frame2();
        f.add(5);
        assertThat(5, Matchers.is(f.getScore()));
    }

} 
