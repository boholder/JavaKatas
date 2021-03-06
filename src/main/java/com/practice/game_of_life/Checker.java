package com.practice.game_of_life;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Checker {

    public static boolean checkCellNextState(boolean[][] grid, int i, int j) {
        int count = countLiveCells(grid, i, j);
        boolean targetIsLive = grid[i][j];
        if (targetIsLive) {
            return judgeLiveCell(count);
        } else {
            return judgeDeadCell(count);
        }
    }

    private static boolean judgeLiveCell(int count) {
        int liveNeighborCount = count - 1;
        return liveNeighborCount == 2 || liveNeighborCount == 3;
    }

    private static boolean judgeDeadCell(int count) {
        return count == 3;
    }

    private static int countLiveCells(boolean[][] grid, int i, int j) {
        int rowSize = grid.length, colSize = grid[0].length;
        AtomicInteger count = new AtomicInteger();
        IntStream.range(-1, 2).forEach(m -> {
            IntStream.range(-1, 2).forEach(n -> {
                if (grid[(i + m + rowSize) % rowSize][(j + n + colSize) % colSize]) {
                    count.getAndIncrement();
                }
            });
        });
        return count.get();
    }
}
