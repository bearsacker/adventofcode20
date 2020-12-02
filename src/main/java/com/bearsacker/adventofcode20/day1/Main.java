package com.bearsacker.adventofcode20.day1;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public final static int WANTED_SUM = 2020;

    public final static int MAX_DEPTH = 2;

    public static void find(ArrayList<Integer> numbers, int startIndex, ArrayList<Integer> previousValues, int depth) {
        for (int i = startIndex; i < numbers.size() - 1; i++) {
            int number = numbers.get(i);
            int sum = previousValues.stream().reduce(0, (a, b) -> a + b) + number;
            int product = previousValues.stream().reduce(1, (a, b) -> a * b) * number;

            if (sum == WANTED_SUM) {
                previousValues.forEach(x -> System.out.print(x + " * "));
                System.out.println(number + " = " + product);
            } else if (depth < MAX_DEPTH) {
                ArrayList<Integer> newPreviousValues = new ArrayList<>(previousValues);
                newPreviousValues.add(number);
                find(numbers, i + 1, newPreviousValues, depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("day1/input.txt"));

        String line = reader.readLine();
        do {
            numbers.add(parseInt(line));
            line = reader.readLine();
        } while (line != null);

        reader.close();

        find(numbers, 0, new ArrayList<>(), 0);
    }

}
