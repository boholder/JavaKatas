package com.practice.word_wrap;

public class Wrapper3 {
    public static String wrap(String s, int col) {
        if (s.length() <= col) {
            return s;
        } else {
            // split one word many times
            // assertEquals("abc\ndef\nghi\nj", wrap("abcdefghij", 3));
            return (s.substring(0, col) + "\n" + wrap(s.substring(col), col));
        }
    }
}
