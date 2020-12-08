package com.bearsacker.adventofcode20.day8;

import static com.bearsacker.adventofcode20.day8.InstructionType.ACC;
import static com.bearsacker.adventofcode20.day8.InstructionType.JMP;
import static com.bearsacker.adventofcode20.day8.InstructionType.NOP;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Test;

public class ProgramTest {

    @Test
    public void parseInstructionTest() {
        LinkedList<Instruction> instructions = new LinkedList<>();
        instructions.add(Instruction.parse("nop +0"));
        instructions.add(Instruction.parse("acc +1"));
        instructions.add(Instruction.parse("jmp +4"));
        instructions.add(Instruction.parse("acc +3"));
        instructions.add(Instruction.parse("jmp -3"));
        instructions.add(Instruction.parse("acc -99"));
        instructions.add(Instruction.parse("acc +1"));
        instructions.add(Instruction.parse("jmp -4"));
        instructions.add(Instruction.parse("acc +6"));

        assertEquals(NOP, instructions.get(0).type);
        assertEquals(0, instructions.get(0).value);
        assertEquals(ACC, instructions.get(1).type);
        assertEquals(1, instructions.get(1).value);
        assertEquals(JMP, instructions.get(2).type);
        assertEquals(4, instructions.get(2).value);
        assertEquals(ACC, instructions.get(3).type);
        assertEquals(3, instructions.get(3).value);
        assertEquals(JMP, instructions.get(4).type);
        assertEquals(-3, instructions.get(4).value);
        assertEquals(ACC, instructions.get(5).type);
        assertEquals(-99, instructions.get(5).value);
        assertEquals(ACC, instructions.get(6).type);
        assertEquals(1, instructions.get(6).value);
        assertEquals(JMP, instructions.get(7).type);
        assertEquals(-4, instructions.get(7).value);
        assertEquals(ACC, instructions.get(8).type);
        assertEquals(6, instructions.get(8).value);
    }

    @Test
    public void runTest() {
        LinkedList<Instruction> instructions = new LinkedList<>();
        instructions.add(Instruction.parse("nop +0"));
        instructions.add(Instruction.parse("acc +1"));
        instructions.add(Instruction.parse("jmp +4"));
        instructions.add(Instruction.parse("acc +3"));
        instructions.add(Instruction.parse("jmp -3"));
        instructions.add(Instruction.parse("acc -99"));
        instructions.add(Instruction.parse("acc +1"));
        instructions.add(Instruction.parse("jmp -4"));
        instructions.add(Instruction.parse("acc +6"));

        Program program = new Program(instructions);
        program.run();

        assertFalse(program.isEndedCorrectly());
        assertEquals(5, program.getAccumulator());
    }

    @Test
    public void runWithFixingTest() {
        LinkedList<Instruction> instructions = new LinkedList<>();
        instructions.add(Instruction.parse("nop +0"));
        instructions.add(Instruction.parse("acc +1"));
        instructions.add(Instruction.parse("jmp +4"));
        instructions.add(Instruction.parse("acc +3"));
        instructions.add(Instruction.parse("jmp -3"));
        instructions.add(Instruction.parse("acc -99"));
        instructions.add(Instruction.parse("acc +1"));
        instructions.add(Instruction.parse("jmp -4"));
        instructions.add(Instruction.parse("acc +6"));

        Program program = new Program(instructions);

        for (int fixingPointer = 0; fixingPointer < program.getLength(); fixingPointer++) {
            program.runWithFix(fixingPointer);
            if (program.isEndedCorrectly()) {
                break;
            }
        }

        assertTrue(program.isEndedCorrectly());
        assertEquals(8, program.getAccumulator());
    }
}
