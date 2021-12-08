package com.bearsacker.utils;

import static java.lang.Math.sqrt;

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

    public Vec2 add(Vec2 other) {
        this.x += other.x;
        this.y += other.y;

        return this;
    }

    public Vec2 mul(float scale) {
        x *= scale;
        y *= scale;

        return this;
    }

    public double length() {
        return sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ")";
    }
}
