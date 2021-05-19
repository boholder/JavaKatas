# The Bowling Game

source article: 
[The Bowling Game: An example of test-first pair programming - Clean Coder](https://sites.google.com/site/unclebobconsultingllc/home/articles/the-bowling-game-an-example-of-test-first-pair-programming)

(It seems that the original website is no longer providing services. 
I found an article on the Internet that looked like a snapshot. 
(Because the pictures in the article are not loaded, there is even no corresponding link))

A Classic Kata, 
which Robert C. Martin uses as an example 
to introduce the definition of Kata in his book "Clean Coder".
It is recommended to read the source article. 
In the article, the two advance the coding process through a dialogue. 
The dialogue also contains an introduction 
to the process of implementing a user story in an XP way. 

## Description

We want to write a bowling ball score calculation program, 
input a player's score sequence, 
and output the score board for each round. 

以下是保龄球的规则：
1. 一局游戏由不确定的轮数组成。玩家需要在每轮游戏中尝试击倒10个pin，每轮有两次尝试机会。
2. 每轮的计分规则：
    * strike(x): 第一球击倒了全部10只pin，得分为

## Input

A sequence of throws. 
A throw is just an `integer` that tells how many pins were knocked down by the ball.

## Output

"A standard bowling score card, 
a set of frames populated with the pins knocked down by each throw, 
and marks denoting spares and strikes. 
The most important number in each frame is the current game score."



## Sample Input

* wrap("",1)
* wrap("word",3)
* wrap("word word",6)

## Sample Output

* ""
* "wor\nd"
* "word\nword"