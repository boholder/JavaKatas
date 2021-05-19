# Word Wrap

source article: http://thecleancoder.blogspot.com/2010/10/craftsman-62-dark-path.html

This Kata tells the process in the form of a dialogue between two programmers,
which is as elegant as Zen koan.

I have tried to use parameterized test methods (since junit4) in this kata (ParameterizedTest1.java),
finally I found out that using these methods CANNOT reduce code, 
but there will be less readable information.

## Description

Writing a class called `Wrapper`, that takes a single static function named `wrap`.
The function use line breaks to break input string to ensure 
no line is longer than given column number.
The column number is a positive integer.

## Input

`wrap` takes two arguments, a `string`, and a `column number`. 

## Output

The function returns the `string`, but with line breaks inserted at just the right places 
to make sure that no line is longer than the column number.
You try to break lines at word boundaries.

## Sample Input

* wrap("",1)
* wrap("word",3)
* wrap("word word",6)

## Sample Output

* ""
* "wor\nd"
* "word\nword"
