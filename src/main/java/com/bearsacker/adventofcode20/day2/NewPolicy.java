package com.bearsacker.adventofcode20.day2;


public class NewPolicy {

    private int firstOccurence;

    private int secondOccurence;

    private char character;

    public NewPolicy(char character, int firstOccurence, int secondOccurence) {
        this.character = character;
        this.firstOccurence = firstOccurence;
        this.secondOccurence = secondOccurence;
    }

    public boolean checkPassword(String password) {
        return password.charAt(firstOccurence - 1) == character ^ password.charAt(secondOccurence - 1) == character;
    }

}
