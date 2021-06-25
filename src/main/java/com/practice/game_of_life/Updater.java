package com.practice.game_of_life;

public class Updater {
    public boolean[][] updateGrid(boolean[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        boolean[][] newGrid = new boolean[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                newGrid[i][j] = Checker.checkCellNextState(grid, i, j);
            }
        }
        return newGrid;
    }
}
