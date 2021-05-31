package com.practice.game_of_life;

import static java.lang.Thread.sleep;

public class Presenter {
    private Updater updater = new Updater();

    public void printOnConsole(boolean[][] initGrid, int time) throws InterruptedException {
        boolean[][] currentGrid = initGrid;
        for (int i = 0; i < time; i++) {
            print(currentGrid, i);
            currentGrid = updater.updateGrid(currentGrid);
            sleep(1000);
        }
    }

    private void print(boolean[][] grid, int time) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        System.out.println(String.format("Generation %d:", time));
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                System.out.print(grid[i][j] ? "#" : "O");
            }
            System.out.println();
        }
    }
}
