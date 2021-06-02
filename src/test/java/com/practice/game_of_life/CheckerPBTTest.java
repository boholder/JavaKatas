package com.practice.game_of_life;

import net.jqwik.api.*;
import net.jqwik.api.arbitraries.ListArbitrary;
import org.hamcrest.Matchers;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckerPBTTest {

    /**
     * Live neighbors count inside checker = count calculated by stream operation.
     * Note that random grid is 3*3 size and we exactly called checker with cell in center.
     */
    @Property
    public void checkerCorrectOnCountingLiveNeighbors(@ForAll("random3By3Grid") boolean[][] grid) {
        int liveCellCount = liveCellCountIn(grid);
        boolean targetCellIsLive = grid[1][1];
        if (targetCellIsLive) {
            expectForLiveCell(grid, 1, 1, liveCellCount - 1);
        } else {
            expectForDeadCell(grid, 1, 1, liveCellCount);
        }
    }

    private int liveCellCountIn(boolean[][] grid) {
        return (int) Arrays.stream(grid)
                .flatMap(array -> IntStream.range(0, array.length).mapToObj(index -> array[index]))
                .filter(cell -> cell)
                .count();
    }

    private void expectForLiveCell(boolean[][] grid, int i, int j, int liveNeighborCount) {
        if (liveNeighborCount < 2 || liveNeighborCount > 3) {
            assertThat(Checker.checkCellNextState(grid, i, j), Matchers.is(false));
        } else {
            assertThat(Checker.checkCellNextState(grid, i, j), Matchers.is(true));
        }
    }

    private void expectForDeadCell(boolean[][] grid, int i, int j, int liveCellCount) {
        if (liveCellCount == 3) {
            assertThat(Checker.checkCellNextState(grid, i, j), Matchers.is(true));
        } else {
            assertThat(Checker.checkCellNextState(grid, i, j), Matchers.is(false));
        }
    }

    @Provide
    public Arbitrary<boolean[][]> random3By3Grid() {
        return randomGivenLengthGrid(3);
    }

    private Arbitrary<boolean[][]> randomGivenLengthGrid(int length) {
        ListArbitrary<Boolean> cells = Arbitraries.of(true, false).list().ofSize((int) Math.pow(length, 2));
        return cells.map(cellList -> {
            boolean[][] grid = new boolean[length][length];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    grid[i][j] = cellList.get(length * i + j);
                }
            }
            return grid;
        });
    }

    /**
     * In 2*2 grid particularly,
     * one cell's live neighbors number will count diagonal cell 4 times,
     * other two cells 2 times.
     */
    @Property
    public void checkerTreatGridAsSimplyConnected(@ForAll("random2By2Grid") boolean[][] grid) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                boolean diagonalCell = grid[index(i + 1)][index(j + 1)];
                int diagonalCount = (diagonalCell ? 1 : 0) * 4;
                boolean downCell = grid[index(i + 1)][j];
                boolean rightCell = grid[i][index(j + 1)];
                int otherCount = ((downCell ? 1 : 0) + (rightCell ? 1 : 0)) * 2;
                int liveNeighborCount = diagonalCount + otherCount;
                boolean targetCellIsLive = grid[i][j];
                if (targetCellIsLive) {
                    expectForLiveCell(grid, i, j, liveNeighborCount);
                } else {
                    expectForDeadCell(grid, i, j, liveNeighborCount);
                }
            }
        }
    }

    /**
     * Made a mistake and jqwik alarmed when first wrote test case above,
     * so add one example-based test case for further testing.
     */
    @Example
    public void exp1() {
        checkerTreatGridAsSimplyConnected(new boolean[][]{new boolean[]{true, true}, new boolean[]{false, false}});
    }

    private int index(int virtualIndex) {
        return (virtualIndex + 2) % 2;
    }

    @Provide
    public Arbitrary<boolean[][]> random2By2Grid() {
        return randomGivenLengthGrid(2);
    }
}
