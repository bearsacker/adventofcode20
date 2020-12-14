package com.bearsacker.adventofcode20.day13;

import static java.math.BigInteger.valueOf;

import java.math.BigInteger;

public class Shuttle {

    private BigInteger number;

    private BigInteger id;

    private BigInteger rest;

    public Shuttle(int id, int number) {
        this.id = valueOf(id);
        this.number = valueOf(number);
        this.rest = valueOf(id - number);
    }

    public long getEarliestDepart(long timestamp) {
        long time = 0;
        while (time < timestamp) {
            time += id.longValue();
        }

        return time;
    }

    public BigInteger getId() {
        return id;
    }

    public BigInteger getNumber() {
        return number;
    }

    public BigInteger getRest() {
        return rest;
    }

    @Override
    public String toString() {
        return "[" + id + " (" + number + ")]";
    }
}
