package com.practice.the_bowling_game;

public class Game4 {
    private int itsScore = 0;

    // -----------------------------------------
    // Instead of adding Frame collection field to Game,
    // they followed "do simplest thing that will get the test to pass" principle,
    // resulted in an integer array, **each number is a throw result**.
    private int[] itsThrows = new int[21];
    // array index counter
    private int itsCurrentThrow = 0;
    // -----------------------------------------

    public int score() {
        return itsScore;
    }

    public void add(int pins) {
        // ------------------------
        // add record of one throw.
        itsThrows[itsCurrentThrow++] = pins;
        // ------------------------
        itsScore += pins;
    }

    // new, calculate given frame No. 's score
    // (must will contain two neighbouring Throw, now)
    public int scoreForFrame(int theFrame) {
        int score = 0;
        int ball = 0;
        //     for ( int ball = 0;
        //      frame > 0 && (ball < itsCurrentThrow);
        //      ball+=2, frame--)
        //    {
        //      score += itsThrows[ball] + itsThrows[ball+1];
        //    }
        // refactor:
        for (int currentFrame = 0;
             currentFrame < theFrame;
             currentFrame++) {
            // score += itsThrows[ball++] + itsThrows[ball++]
            // refactor:
            int firstThrow = itsThrows[ball++];
            int secondThrow = itsThrows[ball++];
            score += firstThrow + secondThrow;
        }

        return score;
    }
}
