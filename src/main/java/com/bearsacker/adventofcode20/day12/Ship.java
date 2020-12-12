package com.bearsacker.adventofcode20.day12;

import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bearsacker.adventofcode20.utils.Vec2;

public class Ship {

    public final static Pattern REGEX_INSTRUCTION = Pattern.compile("^([NSEWLRF]{1})([0-9]+)$");

    private int angle;

    private Vec2 position;

    public Ship() {
        angle = Direction.EAST.getAngle();
        position = new Vec2();
    }

    public void applyInstruction(String instruction) {
        Matcher matcher = REGEX_INSTRUCTION.matcher(instruction);
        if (matcher.matches()) {
            String command = matcher.group(1);
            int value = Integer.parseInt(matcher.group(2));

            switch (command) {
            case "N":
                position.add(new Vec2(0, -value));
                break;
            case "S":
                position.add(new Vec2(0, value));
                break;
            case "E":
                position.add(new Vec2(value, 0));
                break;
            case "W":
                position.add(new Vec2(-value, 0));
                break;
            case "L":
                setAngle(-value);
                break;
            case "R":
                setAngle(value);
                break;
            case "F":
                forward(value);
                break;
            default:
                break;
            }
        } else {
            System.err.println(instruction);
        }
    }

    public void forward(int distance) {
        position.x -= (int) (distance * cos(toRadians(angle)));
        position.y += (int) (distance * sin(toRadians(angle)));
    }

    public void setAngle(int angle) {
        this.angle += angle;
        this.angle = this.angle % 360;
        if (this.angle < 0) {
            this.angle = 360 + this.angle;
        }
    }

    public Vec2 getPosition() {
        return position;
    }

    public int getManhattanDistance() {
        return abs(position.x) + abs(position.y);
    }
}
