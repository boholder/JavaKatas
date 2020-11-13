package com.practice.wordwrap;

public class Wrapper2 {
    public static String wrap(String s, int col) {
        if (s.length() <= col)
            return s;
        else
            // split one word
            return (s.substring(0, col) + "\n" + s.substring(col));
    }
}
