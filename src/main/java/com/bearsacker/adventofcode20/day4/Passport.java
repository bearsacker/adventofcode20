package com.bearsacker.adventofcode20.day4;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passport {

    private final static Pattern REGEX = Pattern.compile("(([a-z]+):([^ \n]*))");

    private HashMap<String, String> data;

    public Passport(String rawData) {
        data = new HashMap<>();

        Matcher matcher = REGEX.matcher(rawData);
        while (matcher.find()) {
            data.put(matcher.group(2), matcher.group(3));
        }
    }

    public boolean containsData(String key) {
        return data.containsKey(key);
    }

    public String getData(String key) {
        return data.get(key);
    }

    public boolean isValid(Verifiable policy) {
        return policy.verify(this);
    }

}
