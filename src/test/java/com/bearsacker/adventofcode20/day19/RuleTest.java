package com.bearsacker.adventofcode20.day19;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import org.junit.Test;

public class RuleTest {

    @Test
    public void getRegexTest() {
        Rule rule0 = new Rule(new ArrayList<>(asList(4, 1, 5)), new ArrayList<>());
        Rule rule1 = new Rule(new ArrayList<>(asList(2, 3)), new ArrayList<>(asList(3, 2)));
        Rule rule2 = new Rule(new ArrayList<>(asList(4, 4)), new ArrayList<>(asList(5, 5)));
        Rule rule3 = new Rule(new ArrayList<>(asList(4, 5)), new ArrayList<>(asList(5, 4)));
        Rule rule4 = new Rule("a");
        Rule rule5 = new Rule("b");

        HashMap<Integer, Rule> rules = new HashMap<>();
        rules.put(0, rule0);
        rules.put(1, rule1);
        rules.put(2, rule2);
        rules.put(3, rule3);
        rules.put(4, rule4);
        rules.put(5, rule5);

        String regex = rules.get(0).getRegex(rules, 0, 0);
        Pattern pattern = Pattern.compile(regex);

        assertEquals(true, pattern.matcher("ababbb").matches());
        assertEquals(false, pattern.matcher("bababa").matches());
        assertEquals(true, pattern.matcher("abbbab").matches());
        assertEquals(false, pattern.matcher("aaabbb").matches());
        assertEquals(false, pattern.matcher("aaaabbb").matches());
    }

}
