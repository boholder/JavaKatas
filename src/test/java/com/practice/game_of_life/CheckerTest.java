package com.practice.game_of_life;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Checker Tester.
 */
public class CheckerTest {
    @Test
    public void liveLessThanTwoDie() {
        boolean[][] gird = getTestGrid(1, 0, 0, 0, 1, 0, 0, 0, 0);
        boolean state = Checker.checkCellNextState(gird, 1, 1);
        assertThat(state, Matchers.is(false));
    }

    @Test
    public void liveMoreThanThreeDie() {
        assertThat(
                Checker.checkCellNextState(
                        getTestGrid(1, 1, 1, 1, 1, 0, 0, 0, 0), 1, 1),
                Matchers.is(false));
    }

    @Test
    public void deadThreeLive() {
        assertThat(
                Checker.checkCellNextState(
                        getTestGrid(1, 1, 1, 0, 0, 0, 0, 0, 0), 1, 1),
                Matchers.is(true));
    }

    @Test
    public void liveTwoLive() {
        assertThat(
                Checker.checkCellNextState(
                        getTestGrid(1, 1, 0, 0, 1, 0, 0, 0, 0), 1, 1),
                Matchers.is(true));
    }

    @Test
    public void liveThreeLive() {
        assertThat(
                Checker.checkCellNextState(
                        getTestGrid(1, 1, 1, 0, 1, 0, 0, 0, 0), 1, 1),
                Matchers.is(true));
    }

    @Test
    public void deadTwoDie() {
        assertThat(
                Checker.checkCellNextState(
                        getTestGrid(1, 1, 0, 0, 0, 0, 0, 0, 0), 1, 1),
                Matchers.is(false));
    }

    @Test
    public void deadFourDie() {
        assertThat(
                Checker.checkCellNextState(
                        getTestGrid(1, 1, 1, 1, 0, 0, 0, 0, 0), 1, 1),
                Matchers.is(false));
    }

    @Test
    public void simplyConnectedThree() {
        boolean[][] grid = getTestGrid(1, 0, 1, 0, 0, 0, 1, 0, 1);
        assertThat(Checker.checkCellNextState(grid, 0, 0), Matchers.is(true));
        assertThat(Checker.checkCellNextState(grid, 0, 2), Matchers.is(true));
        assertThat(Checker.checkCellNextState(grid, 2, 0), Matchers.is(true));
        assertThat(Checker.checkCellNextState(grid, 2, 2), Matchers.is(true));
    }

    @Test
    public void simpleConnectedTwo() {
        boolean[][] grid = getTestGrid(1, 0, 1, 0, 0, 0, 0, 0, 1);
        assertThat(Checker.checkCellNextState(grid, 0, 0), Matchers.is(true));
        assertThat(Checker.checkCellNextState(grid, 0, 2), Matchers.is(true));
        assertThat(Checker.checkCellNextState(grid, 2, 2), Matchers.is(true));
    }

    private boolean[][] getTestGrid(int... data) {
        boolean[][] gird = new boolean[3][3];
        IntStream.range(0, 3).forEachOrdered(i ->
                IntStream.range(0, 3).forEachOrdered(j ->
                        gird[i][j] = data[i * 3 + j] == 1));
        return gird;
    }
}