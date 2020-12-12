package com.bearsacker.adventofcode20.day02;


public class SecondPolicy {

    private int firstOccurence;

    private int secondOccurence;

    private char character;

    public SecondPolicy(char character, int firstOccurence, int secondOccurence) {
        this.character = character;
        this.firstOccurence = firstOccurence;
        this.secondOccurence = secondOccurence;
    }

    public boolean checkPassword(String password) {
        return password.charAt(firstOccurence - 1) == character ^ password.charAt(secondOccurence - 1) == character;
    }

}
