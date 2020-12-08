package com.bearsacker.adventofcode20.day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Day8 {

    public static void main(String[] args) throws IOException {
        System.out.println("\n--- Day 8: Handheld Halting ---");

        LinkedList<Instruction> instructions = new LinkedList<>();

        BufferedReader reader = new BufferedReader(new FileReader("day8/input.txt"));
        reader.lines().forEach(line -> instructions.add(Instruction.parse(line)));
        reader.close();

        Program program = new Program(instructions);
        program.run();

        System.out.println("Part 1: " + program.getAccumulator());

        for (int fixingPointer = 0; fixingPointer < program.getLength(); fixingPointer++) {
            program.runWithFix(fixingPointer);
            if (program.isEndedCorrectly()) {
                break;
            }
        }

        System.out.println("Part 2: " + program.getAccumulator());
    }

}
