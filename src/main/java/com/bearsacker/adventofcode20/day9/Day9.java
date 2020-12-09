package com.bearsacker.adventofcode20.day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day9 {

    public static void main(String[] args) throws IOException {
        System.out.println("\n--- Day 9: Encoding Error ---");

        ArrayList<Long> numbers = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("day9/input.txt"));
        reader.lines().forEach(line -> numbers.add(Long.parseLong(line)));
        reader.close();

        XMas xmas = new XMas(numbers, 25);

        Long wrongNumber = xmas.firstWrongNumber();
        System.out.println("Part 1: " + wrongNumber);

        ArrayList<Long> sumList = xmas.findContiguousSum(wrongNumber);
        System.out.println("Part 2: " + (sumList.get(0) + sumList.get(sumList.size() - 1)));
    }

}
