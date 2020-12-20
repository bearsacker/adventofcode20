package com.bearsacker.adventofcode20.day20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day20 {

    public static void main(String[] args) throws IOException {
        System.out.println("\n--- Day 20: Jurassic Jigsaw ---");

        BufferedReader reader = new BufferedReader(new FileReader("2020/day20/input.txt"));
        List<String> lines = reader.lines().collect(Collectors.toList());
        reader.close();
    }

}
