package com.practice.the_bowling_game;

public class Frame2 {
    private int itsScore = 0;

    public int getScore() {
        return itsScore;
    }

    // new
    public void add(int pins) {
        itsScore += pins;
    }
}
