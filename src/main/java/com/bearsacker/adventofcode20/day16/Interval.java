package com.bearsacker.adventofcode20.day16;


public class Interval {

    private int min;

    private int max;

    public Interval(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public boolean isValid(Long value) {
        return value >= min && value <= max;
    }

}
