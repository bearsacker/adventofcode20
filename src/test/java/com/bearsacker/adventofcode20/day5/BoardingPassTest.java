package com.bearsacker.adventofcode20.day5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoardingPassTest {

    @Test
    public void constructorTest() {
        BoardingPass b = new BoardingPass("FBFBBFFRLR");
        BoardingPass b1 = new BoardingPass("BFFFBBFRRR");
        BoardingPass b2 = new BoardingPass("FFFBBBFRRR");
        BoardingPass b3 = new BoardingPass("BBFFBBFRLL");

        assertEquals(357, b.getSeatId());
        assertEquals(567, b1.getSeatId());
        assertEquals(119, b2.getSeatId());
        assertEquals(820, b3.getSeatId());
    }

}
