package com.bearsacker.adventofcode20.day10;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class ChainTest {

    @Test
    public void example1Test() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(16);
        numbers.add(10);
        numbers.add(15);
        numbers.add(5);
        numbers.add(1);
        numbers.add(11);
        numbers.add(7);
        numbers.add(19);
        numbers.add(6);
        numbers.add(12);
        numbers.add(4);

        Chain chain = new Chain(numbers);
        assertEquals(13, chain.getLength());

        HashMap<Integer, Integer> differences = chain.sortChainByDifferences();
        assertEquals(2, differences.size());
        assertEquals(7, differences.get(1).intValue());
        assertEquals(5, differences.get(3).intValue());

        assertEquals(8, chain.findArrangements());
    }

    @Test
    public void example2Test() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(28);
        numbers.add(33);
        numbers.add(18);
        numbers.add(42);
        numbers.add(31);
        numbers.add(14);
        numbers.add(46);
        numbers.add(20);
        numbers.add(48);
        numbers.add(47);
        numbers.add(24);
        numbers.add(23);
        numbers.add(49);
        numbers.add(45);
        numbers.add(19);
        numbers.add(38);
        numbers.add(39);
        numbers.add(11);
        numbers.add(1);
        numbers.add(32);
        numbers.add(25);
        numbers.add(35);
        numbers.add(8);
        numbers.add(17);
        numbers.add(7);
        numbers.add(9);
        numbers.add(4);
        numbers.add(2);
        numbers.add(34);
        numbers.add(10);
        numbers.add(3);

        Chain chain = new Chain(numbers);
        assertEquals(33, chain.getLength());

        HashMap<Integer, Integer> differences = chain.sortChainByDifferences();
        assertEquals(2, differences.size());
        assertEquals(22, differences.get(1).intValue());
        assertEquals(10, differences.get(3).intValue());

        assertEquals(19208, chain.findArrangements());
    }

    @Test
    public void example3Test() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(16);
        numbers.add(10);
        numbers.add(15);
        numbers.add(5);
        numbers.add(1);
        numbers.add(11);
        numbers.add(7);
        numbers.add(19);
        numbers.add(6);
        numbers.add(12);
        numbers.add(4);
        numbers.add(18);

        Chain chain = new Chain(numbers);
        assertEquals(24, chain.findArrangements());
    }

}
