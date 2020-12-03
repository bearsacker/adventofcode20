package com.bearsacker.adventofcode20.day3;


public class Vec2 {

    public int x;

    public int y;

    public Vec2() {
        x = 0;
        y = 0;
    }

    public Vec2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vec2(Vec2 other) {
        this.x = other.x;
        this.y = other.y;
    }

    public void add(Vec2 other) {
        this.x += other.x;
        this.y += other.y;
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ")";
    }
}
