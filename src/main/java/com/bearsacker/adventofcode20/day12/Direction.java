package com.bearsacker.adventofcode20.day12;


public enum Direction {
    NORTH(0), EAST(90), SOUTH(180), WEST(270);

    private int angle;

    private Direction(int angle) {
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }
}
