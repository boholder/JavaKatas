package com.practice.wordwrap;

public class Wrapper5 {
    // Refactoring codes (this work should be done in every TDD loop,
    // but it seems only worth doing at this loop (loop 4).

    public static String wrap(String s, int col) {
        return new Wrapper5(col).wrap(s);
    }

    private int col;

    private String wrap(String s) {
        if (s.length() <= col) {
            return s;
        }
        int space = (s.substring(0, col).lastIndexOf(' '));
        if (space != -1) {
            return breakLine(s, space, 1);
        } else if (s.charAt(col) == ' ') {
            return breakLine(s, col, 1);
        } else {
            return breakLine(s, col, 0);
        }
    }

    // The Builder Pattern
    // https://www.michaelsafyan.com/tech/design/patterns/builder
    // Or:
    // "In delegating constructors,
    // you can have one constructor that takes lots of different options
    // that is really an implementation detail,
    // so you make it private, but then your remaining constructors delegate to it."
    // https://stackoverflow.com/questions/2816123/can-a-constructor-in-java-be-private
    private Wrapper5(int col) {
        this.col = col;
    }

    // Extract duplicated code as a method.
    private String breakLine(String s, int pos, int gap) {
        return s.substring(0, pos) + "\n" + wrap(s.substring(pos + gap), col);
    }
}
