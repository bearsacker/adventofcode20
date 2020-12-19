package com.bearsacker.adventofcode20.day19;

import java.util.ArrayList;
import java.util.HashMap;

public class Rule {

    private ArrayList<Integer> left;

    private ArrayList<Integer> right;

    private String value;

    private int alreadyCalledItself;

    public Rule(ArrayList<Integer> left, ArrayList<Integer> right) {
        this.left = left;
        this.right = right;
    }

    public Rule(String value) {
        this.value = value;
        this.left = new ArrayList<>();
        this.right = new ArrayList<>();
    }

    public String getRegex(HashMap<Integer, Rule> rules, int previous, int number) {
        if (value != null) {
            return value;
        }

        String regex = "(";
        for (Integer rule : left) {
            regex += rules.get(rule).getRegex(rules, number, rule);
        }
        if (!right.isEmpty()) {
            regex += "|";
            for (Integer rule : right) {
                if (number == rule) {
                    if (previous == number) {
                        alreadyCalledItself++;
                    } else {
                        alreadyCalledItself = 0;
                    }

                    if (alreadyCalledItself <= 1) {
                        regex += rules.get(rule).getRegex(rules, number, rule);
                    } else {
                        regex += ".+";
                    }
                } else {
                    regex += rules.get(rule).getRegex(rules, number, rule);
                }
            }
        }

        return regex + ")";
    }
}
