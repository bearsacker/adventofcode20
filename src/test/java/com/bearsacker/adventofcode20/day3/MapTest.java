package com.bearsacker.adventofcode20.day3;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class MapTest {

    @Test
    public void countTreesForDirectionTest() {
        List<String> inputFile = asList(
                "..##.......", //
                "#...#...#..", //
                ".#....#..#.", //
                "..#.#...#.#", //
                ".#...##..#.", //
                "..#.##.....", //
                ".#.#.#....#", //
                ".#........#", //
                "#.##...#...", //
                "#...##....#", //
                ".#..#...#.#");

        Map map = new Map(inputFile);

        assertEquals(7, map.countTreesForDirection(new Vec2(3, 1)));
    }
}
