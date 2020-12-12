package com.bearsacker.adventofcode20.day09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class XMas {

    private List<Long> numbers;

    private int preambuleLength;

    public XMas(List<Long> numbers, int preambuleLength) {
        this.numbers = numbers;
        this.preambuleLength = preambuleLength;
    }

    public boolean isValid(int index) {
        if (index < preambuleLength) {
            return false;
        }

        return findSum(numbers.get(index), numbers.subList(index - preambuleLength, index));
    }

    public Long firstWrongNumber() {
        Long wrongNumber = null;
        for (int i = preambuleLength; i < numbers.size(); i++) {
            if (!isValid(i)) {
                return numbers.get(i);
            }
        }

        return wrongNumber;
    }

    private boolean findSum(long wantedSum, List<Long> numbers) {
        return findSum(wantedSum, numbers, 0, 0, 0);
    }

    private boolean findSum(long wantedSum, List<Long> numbers, int startIndex, long sum, int depth) {
        boolean result = false;

        for (int i = startIndex; i < numbers.size(); i++) {
            long number = numbers.get(i);

            if (sum + number == wantedSum) {
                return true;
            } else if (depth < 1) {
                result = result || findSum(wantedSum, numbers, i + 1, sum + number, depth + 1);
            }
        }

        return result;
    }

    public ArrayList<Long> findContiguousSum(long wantedSum) {
        ArrayList<Long> sumList = new ArrayList<>();

        for (int i = 0; i < numbers.size() - 1; i++) {
            sumList.clear();
            sumList.add(numbers.get(i));

            for (int j = i + 1; j < numbers.size(); j++) {
                sumList.add(numbers.get(j));
                long sum = sumList.stream().reduce(0L, (a, b) -> a + b);

                if (sum == wantedSum) {
                    Collections.sort(sumList);

                    return sumList;
                } else if (sum > wantedSum) {
                    break;
                }
            }
        }

        sumList.clear();

        return sumList;
    }
}
