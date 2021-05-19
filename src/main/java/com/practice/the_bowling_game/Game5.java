package com.practice.the_bowling_game;

public class Game5 {
    private int itsScore = 0;
    private int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;

    public int score() {
        return itsScore;
    }

    public void add(int pins) {
        itsThrows[itsCurrentThrow++] = pins;
        itsScore += pins;
    }

    public int scoreForFrame(int theFrame) {
        int score = 0;
        int ball = 0;
        for (int currentFrame = 0;
             currentFrame < theFrame;
             currentFrame++) {
            int firstThrow = itsThrows[ball++];
            int secondThrow = itsThrows[ball++];
            int frameScore = firstThrow + secondThrow;

            // spare needs next frames first throw,
            // so the score calculation needs to be changed.
            if (frameScore == 10)
                score += frameScore + itsThrows[ball];
            else
                score += frameScore;
            // ------------------------
        }
        return score;
    }
}
