package com.bearsacker.adventofcode20.utils;

import static java.lang.Math.sqrt;

public class Vec4 {

    public int x;

    public int y;

    public int z;

    public int w;

    public Vec4() {
        x = 0;
        y = 0;
        z = 0;
        w = 0;
    }

    public Vec4(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vec4(Vec4 other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.w = other.w;
    }

    public Vec4 add(Vec4 other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
        this.w += other.w;

        return this;
    }

    public Vec4 mul(float scale) {
        x *= scale;
        y *= scale;
        z *= scale;
        w *= scale;

        return this;
    }

    public double length() {
        return sqrt(x * x + y * y + z * z + w * w);
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ";" + z + ";" + w + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        result = prime * result + z;
        result = prime * result + w;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vec4 other = (Vec4) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        if (z != other.z)
            return false;
        if (w != other.w)
            return false;
        return true;
    }
}
