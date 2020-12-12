package com.bearsacker.adventofcode20.day08;

import static com.bearsacker.adventofcode20.day08.InstructionType.JMP;

public class Jmp extends Instruction {

    public Jmp(int value) {
        super(JMP, value);
    }

    @Override
    public void run(Program program) {
        program.setPointer(program.getPointer() + value - 1);
    }

}
