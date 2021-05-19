package com.practice.the_bowling_game;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Game3 Tester.
 */
public class Game3Test {

    // before implement of Game3 class.
    @Test
    public void testOneThrow() {
        Game3 g = new Game3();
        g.add(5);
        assertThat(5, Matchers.is(g.score()));
    }

    // then write this case to check if Game class can handle not-spare situation.
    @Test
    public void testTwoThrowsNoMark() {
        Game3 g = new Game3();
        g.add(5);
        g.add(4);
        assertThat(9, Matchers.is(g.score()));
    }
} 
