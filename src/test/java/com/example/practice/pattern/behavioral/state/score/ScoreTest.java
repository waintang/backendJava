package com.example.practice.pattern.behavioral.state.score;

public class ScoreTest {
    public static void main(String[] args) {
        ScoreContext context =  new ScoreContext();

        context.add(10);
        context.add(50);
        context.add(31);
        context.add(-41);

        context.printStateName();
    }
}
