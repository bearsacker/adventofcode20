package com.bearsacker.adventofcode20.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Chain {

    private LinkedList<Integer> jolts;

    public Chain(ArrayList<Integer> numbers) {
        jolts = new LinkedList<>();
        jolts.add(0);

        numbers.add(0);
        Collections.sort(numbers);

        for (int i = 1; i < numbers.size(); i++) {
            int diff = numbers.get(i) - numbers.get(i - 1);
            if (diff >= 1 && diff <= 3) {
                jolts.add(numbers.get(i));
            } else {
                break;
            }
        }

        jolts.add(jolts.getLast() + 3);
    }

    public int getLength() {
        return jolts.size();
    }

    public HashMap<Integer, Integer> sortChainByDifferences() {
        HashMap<Integer, Integer> differences = new HashMap<>();

        for (int i = 0; i < jolts.size() - 1; i++) {
            int diff = jolts.get(i + 1) - jolts.get(i);
            if (differences.containsKey(diff)) {
                differences.put(diff, differences.get(diff) + 1);
            } else {
                differences.put(diff, 1);
            }
        }

        return differences;
    }

    public long findArrangements() {
        return findArrangements(new HashMap<>(), 0);
    }

    private long findArrangements(HashMap<Integer, Long> cache, int current) {
        if (current == jolts.getLast()) {
            return 1;
        } else if (cache.containsKey(current)) {
            return cache.get(current);
        }

        long count = 0;
        if (jolts.contains(current + 1)) {
            count += findArrangements(cache, current + 1);
        }
        if (jolts.contains(current + 2)) {
            count += findArrangements(cache, current + 2);
        }
        if (jolts.contains(current + 3)) {
            count += findArrangements(cache, current + 3);
        }

        cache.put(current, count);

        return count;
    }

    @Override
    public String toString() {
        String result = "";

        for (Integer jolt : jolts) {
            result += jolt + "-";
        }

        return result;
    }

}
