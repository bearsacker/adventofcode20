package com.bearsacker.adventofcode20.utils;


public class Interval {

    private long min;

    private long max;

    public Interval(long min, long max) {
        this.min = min;
        this.max = max;
    }

    public long getMin() {
        return min;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public boolean isValueInto(long value) {
        return value >= min && value <= max;
    }

}
