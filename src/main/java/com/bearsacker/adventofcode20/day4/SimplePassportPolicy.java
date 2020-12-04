package com.bearsacker.adventofcode20.day4;


public class SimplePassportPolicy implements Verifiable {

    private static SimplePassportPolicy INSTANCE = new SimplePassportPolicy();

    public static SimplePassportPolicy get() {
        return INSTANCE;
    }

    @Override
    public boolean verify(Passport passport) {
        return passport.containsData("byr") && passport.containsData("iyr") && passport.containsData("eyr") && passport.containsData("hgt")
                && passport.containsData("hcl") && passport.containsData("ecl") && passport.containsData("pid");
    }

}
