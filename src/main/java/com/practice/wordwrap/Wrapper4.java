package com.practice.wordwrap;


public class Wrapper4 {
    // In origin article, the author broke this step into 3 steps,
    // each step consider about one position combination.
    // Plz pay attention to the consideration of boundary values in this step.
    public static String wrap(String s, int col) {
        if (s.length() <= col)
            return s;
        int space = (s.substring(0, col).lastIndexOf(' '));
        if (space != -1)
            // line length > space position, the diff is only 1
            // (split on ahead space position)
            return (s.substring(0, space) + "\n" + wrap(s.substring(space + 1), col));
        else if (s.charAt(col) == ' ')
            // line length == space position, the diff is 0
            // (replace space with "\n")
            return (s.substring(0, col) + "\n" + wrap(s.substring(col + 1), col));
        else
            // line length < space position,
            // just split the string right on limit length,
            // let next recursion thinks about remain string processing.
            return (s.substring(0, col) + "\n" + wrap(s.substring(col), col));
    }
}