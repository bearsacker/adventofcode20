package com.bearsacker.adventofcode20.day1;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int find(int wantedSum, List<Integer> numbers, int maxDepth) {
        return find(wantedSum, numbers, maxDepth, 0, new ArrayList<>(), 0);
    }

    public static int find(int wantedSum, List<Integer> numbers, int maxDepth, int startIndex, ArrayList<Integer> previousValues,
            int depth) {
        int result = 0;

        for (int i = startIndex; i < numbers.size() - 1; i++) {
            int number = numbers.get(i);
            int sum = previousValues.stream().reduce(0, (a, b) -> a + b) + number;
            int product = previousValues.stream().reduce(1, (a, b) -> a * b) * number;

            if (sum == wantedSum) {
                return product;
            } else if (depth < maxDepth) {
                ArrayList<Integer> newPreviousValues = new ArrayList<>(previousValues);
                newPreviousValues.add(number);

                result = max(result, find(wantedSum, numbers, maxDepth, i + 1, newPreviousValues, depth + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("day1/input.txt"));
        reader.lines().forEach(x -> numbers.add(parseInt(x)));
        reader.close();

        System.out.println("Part 1: " + find(2020, numbers, 1));
        System.out.println("Part 2: " + find(2020, numbers, 2));
    }

}
