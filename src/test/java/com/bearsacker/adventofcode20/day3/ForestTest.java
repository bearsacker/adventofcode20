package com.bearsacker.adventofcode20.day3;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.bearsacker.adventofcode20.utils.Vec2;

public class ForestTest {

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

        Forest map = new Forest(inputFile);

        assertEquals(7, map.countTreesForDirection(new Vec2(3, 1)));
    }
}
