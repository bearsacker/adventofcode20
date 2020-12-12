package com.bearsacker.adventofcode20.day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day12 {

    public static void main(String[] args) throws IOException {
        System.out.println("\n--- Day 12: Rain Risk ---");

        BufferedReader reader = new BufferedReader(new FileReader("day12/input.txt"));
        List<String> instructions = reader.lines().collect(Collectors.toList());
        reader.close();

        Ship ship = new Ship();
        instructions.forEach(instruction -> ship.applyInstruction(instruction));

        System.out.println("Part 1: " + ship.getManhattanDistance());
    }

}
