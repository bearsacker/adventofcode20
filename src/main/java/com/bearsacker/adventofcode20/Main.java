package com.bearsacker.adventofcode20;

import java.io.IOException;

import com.bearsacker.adventofcode20.day1.Day1;
import com.bearsacker.adventofcode20.day2.Day2;
import com.bearsacker.adventofcode20.day3.Day3;
import com.bearsacker.adventofcode20.day4.Day4;
import com.bearsacker.adventofcode20.day5.Day5;
import com.bearsacker.adventofcode20.day6.Day6;
import com.bearsacker.adventofcode20.day7.Day7;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Advent of Code 2020");

        System.out.println("\n--- Day 1: Report Repair ---");
        Day1.main(args);

        System.out.println("\n--- Day 2: Password Philosophy ---");
        Day2.main(args);

        System.out.println("\n--- Day 3: Toboggan Trajectory ---");
        Day3.main(args);

        System.out.println("\n--- Day 4: Passport Processing ---");
        Day4.main(args);

        System.out.println("\n--- Day 5: Binary Boarding ---");
        Day5.main(args);

        System.out.println("\n--- Day 6: Custom Customs ---");
        Day6.main(args);

        System.out.println("\n--- Day 7: Handy Haversacks ---");
        Day7.main(args);
    }

}
