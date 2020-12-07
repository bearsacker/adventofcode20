package com.bearsacker.adventofcode20.day7;

import static java.lang.Integer.parseInt;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rule {

    private final static Pattern REGEX = Pattern.compile("(?>(?>([a-z ]+) bags contain)|(?>([0-9]+)? ([a-z ]+) (?>bag)+))");

    private String name;

    private HashMap<String, Integer> dependencies;

    public Rule(String line) {
        dependencies = new HashMap<>();

        Matcher matcher = REGEX.matcher(line);
        for (int i = 0; matcher.find(); i++) {
            if (i == 0) {
                name = matcher.group(1);
            } else if (matcher.group(2) != null) {
                dependencies.put(matcher.group(3), parseInt(matcher.group(2)));
            }
        }
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Integer> getDependencies() {
        return dependencies;
    }

    public boolean hasDependencies() {
        return !dependencies.isEmpty();
    }

}
