package com.bearsacker.adventofcode20.day15;

import java.util.HashMap;
import java.util.List;

public class MemoryGame {

    private HashMap<Integer, Integer> occurences;

    private int lastNumber;

    private int turn;

    public MemoryGame(List<Integer> firstTurns) {
        occurences = new HashMap<>();
        for (turn = 0; turn < firstTurns.size(); turn++) {
            lastNumber = firstTurns.get(turn);
            occurences.put(lastNumber, turn + 1);
        }
    }

    public void nextTurn() {
        int number = 0;
        if (occurences.containsKey(lastNumber)) {
            number = turn - occurences.get(lastNumber);
        }

        occurences.put(lastNumber, turn);
        lastNumber = number;

        turn++;
    }

    public int getLastNumber() {
        return lastNumber;
    }

    public int getTurn() {
        return turn;
    }

}
