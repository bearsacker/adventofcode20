package com.bearsacker.adventofcode21.day03;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class Day3Test {

    private final static List<String> EXAMPLE = asList(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010");

    @Test
    public void getGammaEpsilonProduct() {
        assertEquals(198, Day3.getGammaEpsilonProduct(EXAMPLE, 5));
    }

    @Test
    public void getOxygen() {
        assertEquals(23, Day3.getOxygen(EXAMPLE, 5));
    }

    @Test
    public void getCO2() {
        assertEquals(10, Day3.getCO2(EXAMPLE, 5));
    }

}
