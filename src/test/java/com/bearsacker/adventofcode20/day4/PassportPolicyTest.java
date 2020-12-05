package com.bearsacker.adventofcode20.day4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PassportPolicyTest {

    @Test
    public void simplePassportPolicyTest() {
        Passport p = new Passport("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm");
        Passport p1 = new Passport("iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929");
        Passport p2 = new Passport("hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm");
        Passport p3 = new Passport("hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in");

        assertEquals(true, p.isValid(SimplePassportPolicy.get()));
        assertEquals(false, p1.isValid(SimplePassportPolicy.get()));
        assertEquals(true, p2.isValid(SimplePassportPolicy.get()));
        assertEquals(false, p3.isValid(SimplePassportPolicy.get()));
    }

    @Test
    public void complexPassportPolicyTest() {
        Passport p = new Passport("eyr:1972 cid:100 hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926");
        Passport p1 = new Passport("iyr:2019 hcl:#602927 eyr:1967 hgt:170cm ecl:grn pid:012533040 byr:1946");
        Passport p2 = new Passport("hcl:dab227 iyr:2012 ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277");
        Passport p3 = new Passport("hgt:59cm ecl:zzz eyr:2038 hcl:74454a iyr:2023 pid:3556412378 byr:2007");

        assertFalse(p.isValid(ComplexPassportPolicy.get()));
        assertFalse(p1.isValid(ComplexPassportPolicy.get()));
        assertFalse(p2.isValid(ComplexPassportPolicy.get()));
        assertFalse(p3.isValid(ComplexPassportPolicy.get()));

        Passport p4 = new Passport("pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980 hcl:#623a2f");
        Passport p5 = new Passport("eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm");
        Passport p6 = new Passport("hcl:#888785 hgt:164cm byr:2001 iyr:2015 cid:88 pid:545766238 ecl:hzl eyr:2022");
        Passport p7 = new Passport("iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719");

        assertTrue(p4.isValid(ComplexPassportPolicy.get()));
        assertTrue(p5.isValid(ComplexPassportPolicy.get()));
        assertTrue(p6.isValid(ComplexPassportPolicy.get()));
        assertTrue(p7.isValid(ComplexPassportPolicy.get()));
    }

}
