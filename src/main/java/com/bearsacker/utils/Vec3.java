package com.bearsacker.utils;

import static java.lang.Math.sqrt;

public class Vec3 {

    public int x;

    public int y;

    public int z;

    public Vec3() {
        x = 0;
        y = 0;
        z = 0;
    }

    public Vec3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3(Vec3 other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
    }

    public Vec3 add(Vec3 other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;

        return this;
    }

    public Vec3 mul(float scale) {
        x *= scale;
        y *= scale;
        z *= scale;

        return this;
    }

    public double length() {
        return sqrt(x * x + y * y + z * z);
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ";" + z + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        result = prime * result + z;
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
        Vec3 other = (Vec3) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        if (z != other.z)
            return false;
        return true;
    }
}
