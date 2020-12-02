package com.bearsacker.adventofcode20.day2;


public class Policy {

    private int min;

    private int max;

    private char character;

    public Policy(char character, int min, int max) {
        this.character = character;
        this.min = min;
        this.max = max;
    }

    public boolean checkPassword(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            count += password.charAt(i) == character ? 1 : 0;
        }

        return count >= min && count <= max;
    }

}
