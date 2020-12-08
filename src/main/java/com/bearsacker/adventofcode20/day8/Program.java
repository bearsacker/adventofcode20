package com.bearsacker.adventofcode20.day8;

import java.util.HashSet;
import java.util.LinkedList;

public class Program {

    private LinkedList<Instruction> instructions;

    private HashSet<Instruction> history;

    private int pointer;

    private int accumulator;

    public Program(LinkedList<Instruction> instructions) {
        this.instructions = instructions;
        history = new HashSet<>();
        pointer = 0;
        accumulator = 0;
    }

    public void run() {
        history.clear();

        for (pointer = 0; pointer < instructions.size(); pointer++) {
            if (!history.add(instructions.get(pointer))) {
                break;
            }

            instructions.get(pointer).run(this);
        }
    }

    public void runWithFix(int fixingPointer) {
        history.clear();
        accumulator = 0;

        Instruction fixedInstruction = instructions.get(fixingPointer);
        switch (fixedInstruction.type) {
        case NOP:
            fixedInstruction = new Jmp(fixedInstruction.value);
            break;
        case JMP:
            fixedInstruction = new Nop(fixedInstruction.value);
            break;
        case ACC:
            break;
        }

        for (pointer = 0; pointer < instructions.size(); pointer++) {
            Instruction instruction = instructions.get(pointer);
            if (pointer == fixingPointer) {
                instruction = fixedInstruction;
            }

            if (!history.add(instruction)) {
                break;
            }

            instruction.run(this);
        }
    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public int getAccumulator() {
        return accumulator;
    }

    public void setAccumulator(int accumulator) {
        this.accumulator = accumulator;
    }

    public boolean isEndedCorrectly() {
        return pointer >= instructions.size();
    }

    public int getLength() {
        return instructions.size();
    }
}
