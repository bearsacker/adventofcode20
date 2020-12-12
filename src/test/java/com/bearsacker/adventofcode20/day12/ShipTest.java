package com.bearsacker.adventofcode20.day12;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class ShipTest {

    @Test
    public void applyInstructionExampleTest() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("F10");
        lines.add("N3");
        lines.add("F7");
        lines.add("R90");
        lines.add("F11");

        Ship ship = new Ship();
        lines.forEach(line -> ship.applyInstruction(line));

        assertEquals(25, ship.getManhattanDistance());
    }

    @Test
    public void applyInstructionExample2Test() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("F10");
        lines.add("R180");
        lines.add("F10");
        lines.add("R90");
        lines.add("F20");
        lines.add("R180");
        lines.add("F20");

        lines.add("E100");
        lines.add("S100");
        lines.add("N100");
        lines.add("W100");

        lines.add("L180");
        lines.add("F20");
        lines.add("L180");
        lines.add("F20");

        Ship ship = new Ship();
        lines.forEach(line -> ship.applyInstruction(line));

        assertEquals(0, ship.getManhattanDistance());
    }

    @Test
    public void applyWaypointInstructionExampleTest() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("F10");
        lines.add("N3");
        lines.add("F7");
        lines.add("R90");
        lines.add("F11");

        Ship ship = new Ship();
        lines.forEach(line -> ship.applyWaypointInstruction(line));

        assertEquals(286, ship.getManhattanDistance());
    }

    @Test
    public void applyWaypointInstructionExample2Test() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("F12");
        lines.add("W1");
        lines.add("N3");
        lines.add("E3");
        lines.add("W3");
        lines.add("F93");
        lines.add("N2");
        lines.add("R90");
        lines.add("N4");
        lines.add("L180");

        Ship ship = new Ship();
        lines.forEach(line -> ship.applyWaypointInstruction(line));

        assertEquals(-6, ship.getWaypoint().x);
        assertEquals(-5, ship.getWaypoint().y);
        assertEquals(1341, ship.getManhattanDistance());
    }
}
