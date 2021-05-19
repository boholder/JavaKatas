package com.practice.the_bowling_game;

// new, they found out that they can't calculate score for strikes or spares with only Frame class.
// So they decided to write a new Game class to contain all Frame instances.
// This class is really same as Frame2 class.
public class Game3 {
    private int itsScore = 0;

    public int score() {
        return itsScore;
    }

    public void add(int pins) {
        itsScore += pins;
    }
}
