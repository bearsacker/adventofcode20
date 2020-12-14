package com.bearsacker.adventofcode20.day14;

import java.util.HashMap;

public class Memory {

    private String mask;

    private HashMap<Long, Binary> memory;

    public Memory() {
        memory = new HashMap<>();
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public void put(Long address, Binary value) {
        memory.put(address, value);
    }

    public long sum() {
        return memory.entrySet().stream().map(x -> x.getValue().getLongValue()).reduce(0L, (a, b) -> a + b);
    }
}
