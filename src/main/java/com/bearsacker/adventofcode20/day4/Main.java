package com.bearsacker.adventofcode20.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Passport> passports = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("day4/input.txt"));

        String passportData = "";
        String line = reader.readLine();
        do {
            passportData += " " + line;

            if (line.isEmpty()) {
                passports.add(new Passport(passportData));
                passportData = "";
            }

            line = reader.readLine();
        } while (line != null);

        passports.add(new Passport(passportData));

        reader.close();

        System.out.println("Part 1: valid passports: " + passports.stream().filter(x -> x.isValid(SimplePassportPolicy.get())).count());
        System.out.println("Part 2: valid passports: " + passports.stream().filter(x -> x.isValid(ComplexPassportPolicy.get())).count());
    }

}
