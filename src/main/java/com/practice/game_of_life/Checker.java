package com.practice.game_of_life;

public class Checker {
    /**
     * 1. Any live cell with fewer than two live neighbours dies
     * 2. Any live cell with two or three live neighbours lives on to the next generation.
     * 3. Any live cell with more than three live neighbours dies
     */
    public boolean checkLiveCellNextTurnState(boolean[][] grid, int i, int j) {
        int count = countLiveNeighborsOfLiveCell(grid, i, j);
        return count >= 2 && count <= 3;
    }

    private int countLiveNeighborsOfLiveCell(boolean[][] grid, int i, int j) {
        // -1 for counted itself.
        return countAlive(grid, i, j) - 1;
    }

    private int countAlive(boolean[][] grid, int i, int j) {
        int rowSize = grid.length;
        int colSize = grid[0].length;

        int count = 0;
        for (int m = -1; m < 2; m++) {
            for (int n = -1; n < 2; n++) {
                if (grid[(i + m + rowSize) % rowSize][(j + n + colSize) % colSize]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Any dead cell with exactly three live neighbours becomes a live cell
     */
    public boolean checkDeadCellNextTurnState(boolean[][] grid, int i, int j) {
        return countLiveNeighborsOfDeadCell(grid, i, j) == 3;
    }

    private int countLiveNeighborsOfDeadCell(boolean[][] grid, int i, int j) {
        return countAlive(grid, i, j);
    }
}
