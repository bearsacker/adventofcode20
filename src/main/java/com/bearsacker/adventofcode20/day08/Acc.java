package com.bearsacker.adventofcode20.day08;

import static com.bearsacker.adventofcode20.day08.InstructionType.ACC;

public class Acc extends Instruction {

    public Acc(int value) {
        super(ACC, value);
    }

    @Override
    public void run(Program program) {
        program.setAccumulator(program.getAccumulator() + value);
    }

}
