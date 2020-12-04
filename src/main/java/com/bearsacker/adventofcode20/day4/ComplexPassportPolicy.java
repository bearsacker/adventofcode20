package com.bearsacker.adventofcode20.day4;

import static java.lang.Integer.parseInt;
import static java.util.regex.Pattern.matches;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexPassportPolicy implements Verifiable {

    private final static String REGEX_YEAR = "[0-9]{4}";

    private final static String REGEX_HEIGHT = "([0-9]+)(in|cm)+";

    private final static String REGEX_HAIR_COLOR = "#[0-9a-f]{6}";

    private final static String REGEX_EYE_COLOR = "amb|blu|brn|gry|grn|hzl|oth";

    private final static String REGEX_PID = "[0-9]{9}";

    private static ComplexPassportPolicy INSTANCE = new ComplexPassportPolicy();

    public static ComplexPassportPolicy get() {
        return INSTANCE;
    }

    @Override
    public boolean verify(Passport passport) {
        if (!passport.containsData("byr") || !passport.containsData("iyr") || !passport.containsData("eyr") || !passport.containsData("hgt")
                || !passport.containsData("hcl") || !passport.containsData("ecl") || !passport.containsData("pid")) {
            return false;
        }

        if (!matches(REGEX_YEAR, passport.getData("byr")) || !matches(REGEX_YEAR, passport.getData("iyr"))
                || !matches(REGEX_YEAR, passport.getData("eyr"))
                || !matches(REGEX_HAIR_COLOR, passport.getData("hcl")) || !matches(REGEX_EYE_COLOR, passport.getData("ecl"))
                || !matches(REGEX_PID, passport.getData("pid"))) {
            return false;
        }

        int byr = parseInt(passport.getData("byr"));
        if (byr < 1920 || byr > 2002) {
            return false;
        }

        int iyr = parseInt(passport.getData("iyr"));
        if (iyr < 2010 || iyr > 2020) {
            return false;
        }

        int eyr = parseInt(passport.getData("eyr"));
        if (eyr < 2020 || eyr > 2030) {
            return false;
        }

        Matcher matcher = Pattern.compile(REGEX_HEIGHT).matcher(passport.getData("hgt"));
        if (!matcher.matches()) {
            return false;
        }

        int hgt = parseInt(matcher.group(1));
        return (matcher.group(2).equals("cm") && hgt >= 150 && hgt <= 193) || (matcher.group(2).equals("in") && hgt >= 59 && hgt <= 76);
    }

}
