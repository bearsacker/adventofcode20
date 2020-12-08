package com.bearsacker.adventofcode20.day8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Instruction {

    public static final Pattern REGEX = Pattern.compile("^(nop|acc|jmp){1} ([-\\+0-9]*)$");

    public static Instruction parse(String rawData) {
        Matcher matcher = REGEX.matcher(rawData);
        if (matcher.matches()) {
            String instruction = matcher.group(1);
            int value = Integer.parseInt(matcher.group(2));

            switch (instruction) {
            case "nop":
                return new Nop(value);
            case "acc":
                return new Acc(value);
            case "jmp":
                return new Jmp(value);
            }
        }

        System.err.println(rawData);
        return null;
    }

    protected InstructionType type;

    protected int value;

    public Instruction(InstructionType type, int value) {
        this.type = type;
        this.value = value;
    }

    public InstructionType getType() {
        return type;
    }

    public abstract void run(Program program);
}
