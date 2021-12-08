package com.bearsacker.adventofcode21.day02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bearsacker.utils.Vec2;

public class Submarine {

    public final static Pattern REGEX_INSTRUCTION = Pattern.compile("^(forward|down|up{1}) ([0-9]+)$");

    private Vec2 position;

    private int aim;

    public Submarine() {
        init();
    }

    public void init() {
        position = new Vec2();
        aim = 0;
    }

    public void applyInstruction(String instruction) {
        Matcher matcher = REGEX_INSTRUCTION.matcher(instruction);
        if (matcher.matches()) {
            String command = matcher.group(1);
            int value = Integer.parseInt(matcher.group(2));

            switch (command) {
            case "forward":
                position.add(new Vec2(value, 0));
                break;
            case "up":
                position.add(new Vec2(0, -value));
                break;
            case "down":
                position.add(new Vec2(0, value));
                break;
            default:
                break;
            }
        }
    }

    public void applyInstructionWithAim(String instruction) {
        Matcher matcher = REGEX_INSTRUCTION.matcher(instruction);
        if (matcher.matches()) {
            String command = matcher.group(1);
            int value = Integer.parseInt(matcher.group(2));

            switch (command) {
            case "forward":
                position.add(new Vec2(value, 0));
                position.add(new Vec2(0, aim * value));
                break;
            case "up":
                aim -= value;
                break;
            case "down":
                aim += value;
                break;
            default:
                break;
            }
        }
    }

    public int getPositionProduct() {
        return position.x * position.y;
    }
}
