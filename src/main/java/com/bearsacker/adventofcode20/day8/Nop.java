package com.bearsacker.adventofcode20.day8;

import static com.bearsacker.adventofcode20.day8.InstructionType.NOP;

public class Nop extends Instruction {

    public Nop(int value) {
        super(NOP, value);
    }

    @Override
    public void run(Program program) {

    }

}
