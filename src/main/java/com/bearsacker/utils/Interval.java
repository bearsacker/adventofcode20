package com.bearsacker.utils;


public class Interval<T extends Number> {

    private T min;

    private T max;

    public Interval(T min, T max) {
        this.min = min;
        this.max = max;
    }

    public T getMin() {
        return min;
    }

    public void setMin(T min) {
        this.min = min;
    }

    public T getMax() {
        return max;
    }

    public void setMax(T max) {
        this.max = max;
    }

    public boolean isValueInto(Number value) {
        return value.longValue() >= min.longValue() && value.longValue() <= max.longValue();
    }

}
