package com.bearsacker.adventofcode21.day04;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class Day4Test {

    private final static List<String> BOARD = asList(
            "14 21 17 24  4",
            "10 16 15  9 19",
            "18  8 23 26 20",
            "22 11 13  6  5",
            " 2  0 12  3  7");

    private final static List<Integer> DRAWS = asList(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24);

    @Test
    public void testBoard() {
        Board board = new Board(BOARD);

        for (int draw : DRAWS) {
            assertFalse(board.isWin());
            board.mark(draw);
        }

        assertTrue(board.isWin());
        assertEquals(188, board.getScore());
    }

}
