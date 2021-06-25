package com.practice.game_of_life;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class BddStyleChecker {
    private final boolean[][] grid;

    private BddStyleChecker(boolean[][] grid) {
        this.grid = grid;
    }

    public static BddStyleChecker given(boolean[][] grid) {
        return new BddStyleChecker(grid);
    }

    public boolean check(int i, int j) {
        int count = getLiveCellCount(i, j);
        boolean targetCellIsLive = grid[i][j];
        if (targetCellIsLive) {
            int liveCellLiveNeighbors = count - 1;
            return liveCellLiveNeighbors == 2 || liveCellLiveNeighbors == 3;
        } else {
            return count == 3;
        }
    }

    private int getLiveCellCount(int i, int j) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        AtomicInteger atomicInteger = new AtomicInteger();
        IntStream.range(-1, 2).forEach(m ->
                IntStream.range(-1, 2).forEach(n -> {
                    if (grid[(i + n + rowSize) % rowSize][(j + m + colSize) % colSize]) {
                        atomicInteger.getAndIncrement();
                    }
                }));
        return atomicInteger.get();
    }
}
