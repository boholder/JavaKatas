package com.practice.the_bowling_game;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class Game4Test {
    @Test
    public void testOneThrow() {
        Game3 g = new Game3();
        g.add(5);
        assertThat(5, Matchers.is(g.score()));
    }

    @Test
    public void testTwoThrowsNoMark() {
        Game3 g = new Game3();
        g.add(5);
        g.add(4);
        assertThat(9, Matchers.is(g.score()));
    }

    // new, they were trying to add Frames in Game class.
    @Test
    public void testFourThrowsNoMark() {
        Game4 g = new Game4();
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertThat(18, Matchers.is(g.score()));
        assertThat(9, Matchers.is(g.scoreForFrame(1)));
        assertThat(18, Matchers.is(g.scoreForFrame(2)));
    }

}
