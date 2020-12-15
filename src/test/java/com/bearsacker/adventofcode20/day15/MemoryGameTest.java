package com.bearsacker.adventofcode20.day15;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MemoryGameTest {

    @Test
    public void nextTurn2020Test() {
        MemoryGame mg = new MemoryGame(asList(1, 3, 2));
        while (mg.getTurn() < 2020) {
            mg.nextTurn();
        }
        assertEquals(1, mg.getLastNumber());

        MemoryGame mg2 = new MemoryGame(asList(2, 1, 3));
        while (mg2.getTurn() < 2020) {
            mg2.nextTurn();
        }
        assertEquals(10, mg2.getLastNumber());

        MemoryGame mg3 = new MemoryGame(asList(1, 2, 3));
        while (mg3.getTurn() < 2020) {
            mg3.nextTurn();
        }
        assertEquals(27, mg3.getLastNumber());

        MemoryGame mg4 = new MemoryGame(asList(2, 3, 1));
        while (mg4.getTurn() < 2020) {
            mg4.nextTurn();
        }
        assertEquals(78, mg4.getLastNumber());

        MemoryGame mg5 = new MemoryGame(asList(3, 2, 1));
        while (mg5.getTurn() < 2020) {
            mg5.nextTurn();
        }
        assertEquals(438, mg5.getLastNumber());

        MemoryGame mg6 = new MemoryGame(asList(3, 1, 2));
        while (mg6.getTurn() < 2020) {
            mg6.nextTurn();
        }
        assertEquals(1836, mg6.getLastNumber());
    }

    @Test
    public void nextTurn30000000Test() {
        MemoryGame mg = new MemoryGame(asList(1, 3, 2));
        while (mg.getTurn() < 30000000) {
            mg.nextTurn();
        }
        assertEquals(2578, mg.getLastNumber());
    }

}
