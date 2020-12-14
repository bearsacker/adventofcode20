package com.bearsacker.adventofcode20.day14;

import static java.lang.Long.parseLong;
import static java.lang.Long.toBinaryString;
import static java.lang.Math.pow;

import java.util.ArrayList;

public class Binary {

    public static final int BITS_SIZE = 36;

    private String value;

    public static ArrayList<String> createTruthTable(int bits) {
        ArrayList<String> table = new ArrayList<>();
        for (int i = 0; i < pow(2, bits); i++) {
            table.add(new Binary(i, bits).getValue());
        }

        return table;
    }

    public Binary(String value) {
        this.value = value;
    }

    public Binary(long longValue) {
        this(longValue, BITS_SIZE);
    }

    public Binary(long longValue, int size) {
        value = toBinaryString(longValue);
        while (value.length() < size) {
            value = "0" + value;
        }
    }

    public Binary(long longValue, String mask) {
        this.value = "";

        String value = toBinaryString(longValue);
        while (value.length() < BITS_SIZE) {
            value = "0" + value;
        }

        for (int i = 0; i < mask.length(); i++) {
            if (mask.charAt(i) == 'X') {
                this.value += value.charAt(i);
            } else {
                this.value += mask.charAt(i);
            }
        }
    }

    public void applyFloatingBitsMask(String mask) {
        String value = "";

        for (int i = 0; i < mask.length(); i++) {
            if (mask.charAt(i) == 'X' || mask.charAt(i) == '1') {
                value += mask.charAt(i);
            } else {
                value += this.value.charAt(i);
            }
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public long getLongValue() {
        return parseLong(value, 2);
    }

    public ArrayList<Long> getLongValues() {
        ArrayList<Long> values = new ArrayList<>();
        int bits = (int) value.chars().filter(ch -> ch == 'X').count();

        String format = value.replace("X", "%s");
        for (String truthTableLine : createTruthTable(bits)) {
            Object[] charArray = (Object[]) truthTableLine.chars().mapToObj(c -> Character.toString((char) c)).toArray(String[]::new);
            values.add(new Binary(String.format(format, charArray)).getLongValue());
        }

        return values;
    }

    @Override
    public String toString() {
        return value;
    }
}
