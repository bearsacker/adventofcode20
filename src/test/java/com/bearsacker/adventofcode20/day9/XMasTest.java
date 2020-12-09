package com.bearsacker.adventofcode20.day9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

public class XMasTest {

    @Test
    public void wrongNumberTest() {
        ArrayList<Long> numbers = new ArrayList<>();
        numbers.add(35L);
        numbers.add(20L);
        numbers.add(15L);
        numbers.add(25L);
        numbers.add(47L);
        numbers.add(40L);
        numbers.add(62L);
        numbers.add(55L);
        numbers.add(65L);
        numbers.add(95L);
        numbers.add(102L);
        numbers.add(117L);
        numbers.add(150L);
        numbers.add(182L);
        numbers.add(127L);
        numbers.add(219L);
        numbers.add(299L);
        numbers.add(277L);
        numbers.add(309L);
        numbers.add(576L);

        XMas xmas = new XMas(numbers, 5);
        Long wrongNumber = xmas.firstWrongNumber();

        assertNotNull(wrongNumber);
        assertEquals(127, wrongNumber.longValue());
    }

    @Test
    public void findContiguousTest() {
        ArrayList<Long> numbers = new ArrayList<>();
        numbers.add(35L);
        numbers.add(20L);
        numbers.add(15L);
        numbers.add(25L);
        numbers.add(47L);
        numbers.add(40L);
        numbers.add(62L);
        numbers.add(55L);
        numbers.add(65L);
        numbers.add(95L);
        numbers.add(102L);
        numbers.add(117L);
        numbers.add(150L);
        numbers.add(182L);
        numbers.add(127L);
        numbers.add(219L);
        numbers.add(299L);
        numbers.add(277L);
        numbers.add(309L);
        numbers.add(576L);

        XMas xmas = new XMas(numbers, 5);
        Long wrongNumber = xmas.firstWrongNumber();

        ArrayList<Long> sumList = xmas.findContiguousSum(wrongNumber);

        assertEquals(4, sumList.size());
        assertEquals(15, sumList.get(0).longValue());
        assertEquals(25, sumList.get(1).longValue());
        assertEquals(40, sumList.get(2).longValue());
        assertEquals(47, sumList.get(3).longValue());
        assertEquals(62, sumList.get(0) + sumList.get(sumList.size() - 1));
    }

}
