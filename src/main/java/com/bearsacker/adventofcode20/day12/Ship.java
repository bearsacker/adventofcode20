package com.bearsacker.adventofcode20.day12;

import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bearsacker.utils.Vec2;

public class Ship {

    public final static Pattern REGEX_INSTRUCTION = Pattern.compile("^([NSEWLRF]{1})([0-9]+)$");

    private int angle;

    private Vec2 position;

    private Vec2 waypoint;

    public Ship() {
        init();
    }

    public void init() {
        angle = Direction.EAST.getAngle();
        position = new Vec2();
        waypoint = new Vec2(10, -1);
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
        }
    }

    public void applyWaypointInstruction(String instruction) {
        Matcher matcher = REGEX_INSTRUCTION.matcher(instruction);
        if (matcher.matches()) {
            String command = matcher.group(1);
            int value = Integer.parseInt(matcher.group(2));

            switch (command) {
            case "N":
                waypoint.add(new Vec2(0, -value));
                break;
            case "S":
                waypoint.add(new Vec2(0, value));
                break;
            case "E":
                waypoint.add(new Vec2(value, 0));
                break;
            case "W":
                waypoint.add(new Vec2(-value, 0));
                break;
            case "L":
                if (value == 90) {
                    waypoint = new Vec2(waypoint.y, -waypoint.x);
                } else if (value == 180) {
                    waypoint = new Vec2(-waypoint.x, -waypoint.y);
                } else if (value == 270) {
                    waypoint = new Vec2(-waypoint.y, waypoint.x);
                }
                break;
            case "R":
                if (value == 90) {
                    waypoint = new Vec2(-waypoint.y, waypoint.x);
                } else if (value == 180) {
                    waypoint = new Vec2(-waypoint.x, -waypoint.y);
                } else if (value == 270) {
                    waypoint = new Vec2(waypoint.y, -waypoint.x);
                }
                break;
            case "F":
                position.add(new Vec2(waypoint).mul(value));
                break;
            default:
                break;
            }
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

    public Vec2 getWaypoint() {
        return waypoint;
    }

    public int getManhattanDistance() {
        return abs(position.x) + abs(position.y);
    }
}
