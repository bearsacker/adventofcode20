package com.bearsacker.adventofcode20.day15;

import static java.util.Arrays.asList;

import java.util.HashMap;
import java.util.List;

import com.bearsacker.adventofcode20.utils.LinkedNonBlockingQueue;

public class MemoryGame {

    private HashMap<Integer, LinkedNonBlockingQueue<Integer>> occurences;

    private int lastNumber;

    private int turnNumber;

    public MemoryGame(List<Integer> firstTurns) {
        lastNumber = 0;
        turnNumber = 0;

        occurences = new HashMap<>();
        for (int i = 0; i < firstTurns.size(); i++) {
            incrementOccurence(firstTurns.get(i), i + 1);
            lastNumber = firstTurns.get(i);
            turnNumber++;
        }
    }

    public void nextTurn() {
        turnNumber++;
        if (countOccurences(lastNumber) == 1) {
            lastNumber = 0;
            incrementOccurence(0, turnNumber);
        } else {
            int difference = getDifferenceLastTurns(lastNumber);
            lastNumber = difference;
            incrementOccurence(difference, turnNumber);
        }
    }

    public long countOccurences(int value) {
        return occurences.get(value).size();
    }

    public int getLastNumber() {
        return lastNumber;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    private void incrementOccurence(int value, int turn) {
        if (occurences.containsKey(value)) {
            occurences.get(value).add(turn);
        } else {
            occurences.put(value, new LinkedNonBlockingQueue<>(asList(turn), 2));
        }
    }

    private int getDifferenceLastTurns(int value) {
        return occurences.get(value).getLast() - occurences.get(value).get(occurences.get(value).size() - 2);
    }
}
