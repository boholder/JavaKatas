package com.practice.game_of_life;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Checker Tester.
 */
public class CheckerTest {
    private Checker checker;
    private final ArrayFactory arrayFactory = new ArrayFactory();

    @Before
    public void before() {
        checker = new Checker();
    }

    @Test
    public void lessThanTwoDie() {
        boolean[][] grid = arrayFactory.generate3x3Array(1, 0, 0, 0, 1, 0, 0, 0, 0);
        assertLiveCellTestResult(grid, 1, 1, false);
    }

    private void assertLiveCellTestResult(boolean[][] grid, int i, int j, boolean expectAlive) {
        boolean alive = checker.checkLiveCellNextTurnState(grid, i, j);
        assertThat(alive, Matchers.is(expectAlive));
    }

    @Test
    public void moreThanThreeDie() {
        boolean[][] grid = arrayFactory.generate3x3Array(1, 1, 1, 1, 1, 0, 0, 0, 0);
        assertLiveCellTestResult(grid, 1, 1, false);
    }

    @Test
    public void twoLive() {
        boolean[][] grid = arrayFactory.generate3x3Array(1, 1, 0, 0, 1, 0, 0, 0, 0);
        assertLiveCellTestResult(grid, 1, 1, true);
    }

    @Test
    public void threeLive() {
        boolean[][] grid = arrayFactory.generate3x3Array(1, 1, 1, 0, 1, 0, 0, 0, 0);
        assertLiveCellTestResult(grid, 1, 1, true);
    }

    @Test
    public void deadCellRespawnAtThree() {
        boolean[][] grid = arrayFactory.generate3x3Array(1, 1, 1, 0, 0, 0, 0, 0, 0);
        boolean alive = checker.checkDeadCellNextTurnState(grid, 1, 1);
        assertThat(alive, Matchers.is(true));
    }

    /**
     * 1,0,1
     * 0,0,0
     * 1,0,1 all four point has three live neighbors.
     */
    @Test
    public void testSimplyConnected() {
        boolean[][] grid = arrayFactory.generate3x3Array(1, 0, 1, 0, 0, 0, 1, 0, 1);
        assertLiveCellTestResult(grid, 0, 0, true);
        assertLiveCellTestResult(grid, 0, 2, true);
        assertLiveCellTestResult(grid, 2, 0, true);
        assertLiveCellTestResult(grid, 2, 2, true);
    }
}

class ArrayFactory {

    /**
     * @param inputs example: 1,1,1,0,0,0,1,1,1
     * @return example: [[1,1,1],[0,0,0,],[1,1,1]]
     */
    public boolean[][] generate3x3Array(int... inputs) {
        if (inputs.length != 9)
            return null;

        int size = 3;
        boolean[][] array = new boolean[size][size];
        int p = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = inputs[p++] == 1;
            }
        }
        return array;
    }
}
