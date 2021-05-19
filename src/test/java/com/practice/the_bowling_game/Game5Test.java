package com.practice.the_bowling_game;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class Game5Test {
    private Game5 g;

    // refactor test to reduce repeat.
    @Before
    public void setUp() {
        g = new Game5();
    }

    @Test
    public void testOneThrow() {
        g.add(5);
        assertThat(5, Matchers.is(g.score()));
    }

    @Test
    public void testTwoThrowsNoMark() {
        g.add(5);
        g.add(4);
        assertThat(9, Matchers.is(g.score()));
    }

    @Test
    public void testFourThrowsNoMark() {
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertThat(18, Matchers.is(g.score()));
        assertThat(9, Matchers.is(g.scoreForFrame(1)));
        assertThat(18, Matchers.is(g.scoreForFrame(2)));
    }

    // new, they wanted to add "spare" into consider.
    // note that the asserts noticed them to change both score() and scoreForFrame().
    @Test
    public void testSimpleFrameAfterSpare() {
        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);
        assertThat(13, Matchers.is(g.scoreForFrame(1)));
        assertThat(18, Matchers.is(g.scoreForFrame(2)));
        assertThat(18, Matchers.is(g.score()));
    }
}
