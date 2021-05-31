package com.practice.game_of_life;

public class GameOfLife {
    public static void main(String[] args) throws InterruptedException {
        Presenter presenter = new Presenter();
        //  presenter.printOnConsole(randomlyGenerateGrid(), 100);
        presenter.printOnConsole(getGlider(), 100);
    }

    private static boolean[][] randomlyGenerateGrid() {
        boolean[][] grid = getEmptyGrid();
        for (int i = 5; i < 10; i++) {
            for (int j = 20; j < 30; j++) {
                if (Math.random() > 0.5) {
                    grid[i][j] = true;
                }
            }
        }
        return grid;
    }

    private static boolean[][] getEmptyGrid() {
        int row = 5;
        int col = 40;
        boolean[][] grid = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = false;
            }
        }
        return grid;
    }

    private static boolean[][] getGlider() {
        boolean[][] grid = getEmptyGrid();
        grid[0][1] = true;
        grid[1][2] = true;
        grid[2][0] = true;
        grid[2][1] = true;
        grid[2][2] = true;
        return grid;
    }
}
