package com.bearsacker.adventofcode20.day6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GroupTest {

    @Test
    public void countsTest() {
        Group g = new Group("abc");
        Group g1 = new Group("a b c");
        Group g2 = new Group("ab ac");
        Group g3 = new Group("a a a a");
        Group g4 = new Group("b");

        assertEquals(3, g.countsAnyone());
        assertEquals(3, g1.countsAnyone());
        assertEquals(3, g2.countsAnyone());
        assertEquals(1, g3.countsAnyone());
        assertEquals(1, g4.countsAnyone());

        assertEquals(3, g.countsEveryone());
        assertEquals(0, g1.countsEveryone());
        assertEquals(1, g2.countsEveryone());
        assertEquals(1, g3.countsEveryone());
        assertEquals(1, g4.countsEveryone());
    }

}
