package com.bearsacker.adventofcode20.day7;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class RuleTest {

    @Test
    public void constructorTest() {
        Rule r = new Rule("light red bags contain 1 bright white bag, 2 muted yellow bags.");
        Rule r1 = new Rule("dark orange bags contain 3 bright white bags, 4 muted yellow bags.");
        Rule r2 = new Rule("bright white bags contain 1 shiny gold bag.");
        Rule r3 = new Rule("muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.");
        Rule r4 = new Rule("shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.");
        Rule r5 = new Rule("dark olive bags contain 3 faded blue bags, 4 dotted black bags.");
        Rule r6 = new Rule("vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.");
        Rule r7 = new Rule("faded blue bags contain no other bags.");
        Rule r8 = new Rule("dotted black bags contain no other bags.");

        assertEquals("light red", r.getName());
        assertEquals(2, r.getDependencies().size());
        assertEquals(1, r.getDependencies().get("bright white").intValue());
        assertEquals(2, r.getDependencies().get("muted yellow").intValue());

        assertEquals("dark orange", r1.getName());
        assertEquals(2, r1.getDependencies().size());
        assertEquals(3, r1.getDependencies().get("bright white").intValue());
        assertEquals(4, r1.getDependencies().get("muted yellow").intValue());

        assertEquals("bright white", r2.getName());
        assertEquals(1, r2.getDependencies().size());
        assertEquals(1, r2.getDependencies().get("shiny gold").intValue());

        assertEquals("muted yellow", r3.getName());
        assertEquals(2, r3.getDependencies().size());
        assertEquals(2, r3.getDependencies().get("shiny gold").intValue());
        assertEquals(9, r3.getDependencies().get("faded blue").intValue());

        assertEquals("shiny gold", r4.getName());
        assertEquals(2, r4.getDependencies().size());
        assertEquals(1, r4.getDependencies().get("dark olive").intValue());
        assertEquals(2, r4.getDependencies().get("vibrant plum").intValue());

        assertEquals("dark olive", r5.getName());
        assertEquals(2, r5.getDependencies().size());
        assertEquals(3, r5.getDependencies().get("faded blue").intValue());
        assertEquals(4, r5.getDependencies().get("dotted black").intValue());

        assertEquals("vibrant plum", r6.getName());
        assertEquals(2, r6.getDependencies().size());
        assertEquals(5, r6.getDependencies().get("faded blue").intValue());
        assertEquals(6, r6.getDependencies().get("dotted black").intValue());

        assertEquals("faded blue", r7.getName());
        assertEquals(0, r7.getDependencies().size());

        assertEquals("dotted black", r8.getName());
        assertEquals(0, r8.getDependencies().size());
    }

    @Test
    public void findTest() {
        Rule r = new Rule("light red bags contain 1 bright white bag, 2 muted yellow bags.");
        Rule r1 = new Rule("dark orange bags contain 3 bright white bags, 4 muted yellow bags.");
        Rule r2 = new Rule("bright white bags contain 1 shiny gold bag.");
        Rule r3 = new Rule("muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.");
        Rule r4 = new Rule("shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.");
        Rule r5 = new Rule("dark olive bags contain 3 faded blue bags, 4 dotted black bags.");
        Rule r6 = new Rule("vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.");
        Rule r7 = new Rule("faded blue bags contain no other bags.");
        Rule r8 = new Rule("dotted black bags contain no other bags.");

        HashMap<String, Rule> rules = new HashMap<>();
        rules.put(r.getName(), r);
        rules.put(r1.getName(), r1);
        rules.put(r2.getName(), r2);
        rules.put(r3.getName(), r3);
        rules.put(r4.getName(), r4);
        rules.put(r5.getName(), r5);
        rules.put(r6.getName(), r6);
        rules.put(r7.getName(), r7);
        rules.put(r8.getName(), r8);

        assertEquals(true, Day7.findBagColor(rules, r, "shiny gold"));
        assertEquals(true, Day7.findBagColor(rules, r1, "shiny gold"));
        assertEquals(true, Day7.findBagColor(rules, r2, "shiny gold"));
        assertEquals(true, Day7.findBagColor(rules, r3, "shiny gold"));
        assertEquals(true, Day7.findBagColor(rules, r4, "shiny gold"));
        assertEquals(false, Day7.findBagColor(rules, r5, "shiny gold"));
        assertEquals(false, Day7.findBagColor(rules, r6, "shiny gold"));
        assertEquals(false, Day7.findBagColor(rules, r7, "shiny gold"));
        assertEquals(false, Day7.findBagColor(rules, r8, "shiny gold"));
    }

    @Test
    public void countExample1Test() {
        Rule r = new Rule("light red bags contain 1 bright white bag, 2 muted yellow bags.");
        Rule r1 = new Rule("dark orange bags contain 3 bright white bags, 4 muted yellow bags.");
        Rule r2 = new Rule("bright white bags contain 1 shiny gold bag.");
        Rule r3 = new Rule("muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.");
        Rule r4 = new Rule("shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.");
        Rule r5 = new Rule("dark olive bags contain 3 faded blue bags, 4 dotted black bags.");
        Rule r6 = new Rule("vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.");
        Rule r7 = new Rule("faded blue bags contain no other bags.");
        Rule r8 = new Rule("dotted black bags contain no other bags.");

        HashMap<String, Rule> rules = new HashMap<>();
        rules.put(r.getName(), r);
        rules.put(r1.getName(), r1);
        rules.put(r2.getName(), r2);
        rules.put(r3.getName(), r3);
        rules.put(r4.getName(), r4);
        rules.put(r5.getName(), r5);
        rules.put(r6.getName(), r6);
        rules.put(r7.getName(), r7);
        rules.put(r8.getName(), r8);

        assertEquals(32, Day7.countBags(rules, rules.get("shiny gold"), true));
    }

    @Test
    public void countExample2Test() {
        Rule r = new Rule("shiny gold bags contain 2 dark red bags.");
        Rule r1 = new Rule("dark red bags contain 2 dark orange bags.");
        Rule r2 = new Rule("dark orange bags contain 2 dark yellow bags.");
        Rule r3 = new Rule("dark yellow bags contain 2 dark green bags.");
        Rule r4 = new Rule("dark green bags contain 2 dark blue bags.");
        Rule r5 = new Rule("dark blue bags contain 2 dark violet bags.");
        Rule r6 = new Rule("dark violet bags contain no other bags.");

        HashMap<String, Rule> rules = new HashMap<>();
        rules.put(r.getName(), r);
        rules.put(r1.getName(), r1);
        rules.put(r2.getName(), r2);
        rules.put(r3.getName(), r3);
        rules.put(r4.getName(), r4);
        rules.put(r5.getName(), r5);
        rules.put(r6.getName(), r6);

        assertEquals(126, Day7.countBags(rules, rules.get("shiny gold"), true));
    }
}
