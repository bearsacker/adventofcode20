package com.bearsacker.adventofcode20.day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Day10 {

    public static void main(String[] args) throws IOException {
        System.out.println("\n--- Day 10: Adapter Array ---");

        ArrayList<Integer> numbers = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("day10/input.txt"));
        reader.lines().forEach(line -> numbers.add(Integer.parseInt(line)));
        reader.close();

        Chain chain = new Chain(numbers);
        HashMap<Integer, Integer> differences = chain.sortChainByDifferences();
        System.out.println("Part 1: " + differences.get(1) * differences.get(3));
        System.out.println("Part 2: " + chain.findArrangements());
    }

}
