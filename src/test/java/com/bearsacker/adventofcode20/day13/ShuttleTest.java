package com.bearsacker.adventofcode20.day13;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class ShuttleTest {

    @Test
    public void findExample1Test() {
        ArrayList<Shuttle> shuttles = Day13.parseShuttles("7,13,x,x,59,x,31,19");
        assertEquals("1068781", Day13.find(shuttles).toString());
    }

    @Test
    public void findExample0Test() {
        ArrayList<Shuttle> shuttles = Day13.parseShuttles("3,5,7");
        assertEquals("54", Day13.find(shuttles).toString());
    }

    @Test
    public void findExample2Test() {
        ArrayList<Shuttle> shuttles = Day13.parseShuttles("17,x,13,19");
        assertEquals("3417", Day13.find(shuttles).toString());
    }

    @Test
    public void findExample3Test() {
        ArrayList<Shuttle> shuttles = Day13.parseShuttles("67,7,59,61");
        assertEquals("754018", Day13.find(shuttles).toString());
    }

    @Test
    public void findExample4Test() {
        ArrayList<Shuttle> shuttles = Day13.parseShuttles("67,x,7,59,61");
        assertEquals("779210", Day13.find(shuttles).toString());
    }

    @Test
    public void findExample5Test() {
        ArrayList<Shuttle> shuttles = Day13.parseShuttles("67,7,x,59,61");
        assertEquals("1261476", Day13.find(shuttles).toString());
    }

    @Test
    public void findExample6Test() {
        ArrayList<Shuttle> shuttles = Day13.parseShuttles("1789,37,47,1889");
        assertEquals("1202161486", Day13.find(shuttles).toString());
    }

}
