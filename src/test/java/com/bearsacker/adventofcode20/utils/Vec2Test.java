package com.bearsacker.adventofcode20.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bearsacker.utils.Vec2;

public class Vec2Test {

    @Test
    public void mulTest() {
        Vec2 v = new Vec2(4, 10);
        v.mul(11f);

        assertEquals(44, v.x);
        assertEquals(110, v.y);

        v = new Vec2(4, 10);
        Vec2 p = new Vec2(1, 10);
        p.add(new Vec2(v).mul(11f));

        assertEquals(4, v.x);
        assertEquals(10, v.y);
        assertEquals(45, p.x);
        assertEquals(120, p.y);
    }
}
