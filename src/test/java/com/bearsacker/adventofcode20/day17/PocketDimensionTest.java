package com.bearsacker.adventofcode20.day17;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class PocketDimensionTest {

    @Test
    public void threeDimensionsTest() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add(".#.");
        lines.add("..#");
        lines.add("###");

        PocketDimension dimension = new PocketDimension(lines);
        assertEquals(5, dimension.countActiveCubes());

        dimension.applyRules();
        assertEquals(11, dimension.countActiveCubes());

        dimension.applyRules();
        assertEquals(21, dimension.countActiveCubes());

        dimension.applyRules();
        assertEquals(38, dimension.countActiveCubes());

        dimension.applyRules();
        dimension.applyRules();
        dimension.applyRules();
        assertEquals(112, dimension.countActiveCubes());
    }

    @Test
    public void fourDimensionsTest() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add(".#.");
        lines.add("..#");
        lines.add("###");

        Pocket4Dimension dimension = new Pocket4Dimension(lines);
        assertEquals(5, dimension.countActiveCubes());

        for (int i = 0; i < 6; i++) {
            dimension.applyRules();
        }
        assertEquals(848, dimension.countActiveCubes());
    }

}
