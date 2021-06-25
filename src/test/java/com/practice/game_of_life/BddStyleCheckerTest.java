package com.practice.game_of_life;

import com.practice.daily.d20210624.BddStyleChecker;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;

public class BddStyleCheckerTest {
    @Test
    public void liveLessThanTwo() {
        assertThat(com.practice.daily.d20210624.BddStyleChecker
                        .given(getLiveGrid(1))
                        .check(1, 1),
                Matchers.is(false));
    }

    @Test
    public void liveMoreThanThreeDie() {
        assertThat(com.practice.daily.d20210624.BddStyleChecker
                        .given(getLiveGrid(4))
                        .check(1, 1),
                Matchers.is(false));
    }

    @Test
    public void liveTwoLive() {
        assertThat(com.practice.daily.d20210624.BddStyleChecker
                        .given(getLiveGrid(2))
                        .check(1, 1),
                Matchers.is(true));
    }

    @Test
    public void liveThreeLive() {
        assertThat(com.practice.daily.d20210624.BddStyleChecker
                        .given(getLiveGrid(3))
                        .check(1, 1),
                Matchers.is(true));
    }

    @Test
    public void deadThreeLive() {
        assertThat(com.practice.daily.d20210624.BddStyleChecker
                        .given(getDeadGrid(3))
                        .check(1, 1),
                Matchers.is(true));
    }

    @Test
    public void deadMoreThanThreeDie() {
        assertThat(com.practice.daily.d20210624.BddStyleChecker
                        .given(getDeadGrid(4))
                        .check(1, 1),
                Matchers.is(false));
    }

    @Test
    public void deadLessThanThreeDie() {
        assertThat(com.practice.daily.d20210624.BddStyleChecker
                        .given(getDeadGrid(2))
                        .check(1, 1),
                Matchers.is(false));
    }

    @Test
    public void simplyConnectedThree() {
        int[] array = Stream.of(1, 0, 1, 0, 0, 0, 1, 0, 1).mapToInt(Integer::intValue).toArray();
        boolean[][] grid = getGridFromArray(array);
        assertThat(com.practice.daily.d20210624.BddStyleChecker.given(grid).check(0, 0), Matchers.is(true));
        assertThat(com.practice.daily.d20210624.BddStyleChecker.given(grid).check(0, 2), Matchers.is(true));
        assertThat(com.practice.daily.d20210624.BddStyleChecker.given(grid).check(2, 0), Matchers.is(true));
        assertThat(com.practice.daily.d20210624.BddStyleChecker.given(grid).check(2, 2), Matchers.is(true));
    }

    @Test
    public void simpleConnectedTwo() {
        int[] array = Stream.of(1, 0, 1, 0, 0, 0, 0, 0, 1).mapToInt(Integer::intValue).toArray();
        boolean[][] grid = getGridFromArray(array);
        assertThat(com.practice.daily.d20210624.BddStyleChecker.given(grid).check(0, 0), Matchers.is(true));
        assertThat(com.practice.daily.d20210624.BddStyleChecker.given(grid).check(0, 2), Matchers.is(true));
        assertThat(BddStyleChecker.given(grid).check(2, 2), Matchers.is(true));
    }

    private boolean[][] getDeadGrid(int liveNeighborsNumber) {
        boolean[][] grid = getGrid(liveNeighborsNumber);
        grid[1][1] = false;
        return grid;
    }

    private boolean[][] getLiveGrid(int liveNeighborsNumber) {
        boolean[][] grid = getGrid(liveNeighborsNumber);
        grid[1][1] = true;
        return grid;
    }


    private boolean[][] getGrid(int liveNeighborsNumber) {
        int[] data = new int[liveNeighborsNumber];
        Arrays.fill(data, 1);
        data = Arrays.copyOf(data, 9);
        return getGridFromArray(data);
    }

    private boolean[][] getGridFromArray(int[] data) {
        boolean[][] grid = new boolean[3][3];
        IntStream.range(0, 3).forEach(i ->
                IntStream.range(0, 3).forEach(j ->
                        grid[i][j] = data[3 * i + j] == 1));
        return grid;
    }
}