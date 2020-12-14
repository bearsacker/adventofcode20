package com.bearsacker.adventofcode20.day14;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class BinaryTest {

    @Test
    public void maskAndLongValueTest() {
        Binary b = new Binary(11, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X");
        assertEquals("000000000000000000000000000001001001", b.getValue());
        assertEquals(73, b.getLongValue());

        Binary b2 = new Binary(101, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X");
        assertEquals("000000000000000000000000000001100101", b2.getValue());
        assertEquals(101, b2.getLongValue());

        Binary b3 = new Binary(0, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X");
        assertEquals("000000000000000000000000000001000000", b3.getValue());
        assertEquals(64, b3.getLongValue());
    }

    @Test
    public void createTruthTableTest() {
        ArrayList<String> t = Binary.createTruthTable(2);
        assertEquals(4, t.size());
        assertEquals("00", t.get(0));
        assertEquals("01", t.get(1));
        assertEquals("10", t.get(2));
        assertEquals("11", t.get(3));

        ArrayList<String> t2 = Binary.createTruthTable(3);
        assertEquals(8, t2.size());
        assertEquals("000", t2.get(0));
        assertEquals("001", t2.get(1));
        assertEquals("010", t2.get(2));
        assertEquals("011", t2.get(3));
        assertEquals("100", t2.get(4));
        assertEquals("101", t2.get(5));
        assertEquals("110", t2.get(6));
        assertEquals("111", t2.get(7));
    }

    @Test
    public void maskAndLongValuesTest() {
        Binary b = new Binary(42);
        b.applyFloatingBitsMask("000000000000000000000000000000X1001X");
        assertEquals("000000000000000000000000000000X1101X", b.getValue());
        ArrayList<Long> values = b.getLongValues();
        assertEquals(4, values.size());
        assertEquals(26L, values.get(0).longValue());
        assertEquals(27L, values.get(1).longValue());
        assertEquals(58L, values.get(2).longValue());
        assertEquals(59L, values.get(3).longValue());

        Binary b2 = new Binary(26);
        b2.applyFloatingBitsMask("00000000000000000000000000000000X0XX");
        assertEquals("00000000000000000000000000000001X0XX", b2.getValue());
        values = b2.getLongValues();
        assertEquals(8, values.size());
        assertEquals(16L, values.get(0).longValue());
        assertEquals(17L, values.get(1).longValue());
        assertEquals(18L, values.get(2).longValue());
        assertEquals(19L, values.get(3).longValue());
        assertEquals(24L, values.get(4).longValue());
        assertEquals(25L, values.get(5).longValue());
        assertEquals(26L, values.get(6).longValue());
        assertEquals(27L, values.get(7).longValue());
    }
}
