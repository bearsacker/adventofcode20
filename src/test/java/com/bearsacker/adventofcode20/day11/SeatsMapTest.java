package com.bearsacker.adventofcode20.day11;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class SeatsMapTest {

    @Test
    public void notPropagatedRulesTest() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("L.LL.LL.LL");
        lines.add("LLLLLLL.LL");
        lines.add("L.L.L..L..");
        lines.add("LLLL.LL.LL");
        lines.add("L.LL.LL.LL");
        lines.add("L.LLLLL.LL");
        lines.add("..L.L.....");
        lines.add("LLLLLLLLLL");
        lines.add("L.LLLLLL.L");
        lines.add("L.LLLLL.LL");

        SeatsMap seatsMap = new SeatsMap(lines);
        assertEquals(10, seatsMap.getWidth());
        assertEquals(10, seatsMap.getHeight());
        assertEquals(0, seatsMap.countSeats(SeatsMap.OCCUPIED));

        int count = 0;
        while (!seatsMap.applyRules(false)) {
            count++;
        }

        assertEquals(5, count);
        assertEquals(37, seatsMap.countSeats(SeatsMap.OCCUPIED));
    }

    @Test
    public void rule2PropagatedTest() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add(".##.##.");
        lines.add("#.#.#.#");
        lines.add("##...##");
        lines.add("...L...");
        lines.add("##...##");
        lines.add("#.#.#.#");
        lines.add(".##.##.");

        SeatsMap seatsMap = new SeatsMap(lines);
        assertEquals(0, seatsMap.findOccupiedAdjacents(3, 3, true));

        lines.clear();
        lines.add(".............");
        lines.add(".L.L.#.#.#.#.");
        lines.add(".............");

        seatsMap = new SeatsMap(lines);
        assertEquals(0, seatsMap.findOccupiedAdjacents(1, 1, true));

        lines.clear();
        lines.add(".......#.");
        lines.add("...#.....");
        lines.add(".#.......");
        lines.add(".........");
        lines.add("..#L....#");
        lines.add("....#....");
        lines.add(".........");
        lines.add("#........");
        lines.add("...#.....");

        seatsMap = new SeatsMap(lines);
        assertEquals(8, seatsMap.findOccupiedAdjacents(3, 4, true));
    }

    @Test
    public void propagatedRulesTest() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("L.LL.LL.LL");
        lines.add("LLLLLLL.LL");
        lines.add("L.L.L..L..");
        lines.add("LLLL.LL.LL");
        lines.add("L.LL.LL.LL");
        lines.add("L.LLLLL.LL");
        lines.add("..L.L.....");
        lines.add("LLLLLLLLLL");
        lines.add("L.LLLLLL.L");
        lines.add("L.LLLLL.LL");

        SeatsMap seatsMap = new SeatsMap(lines);
        assertEquals(10, seatsMap.getWidth());
        assertEquals(10, seatsMap.getHeight());
        assertEquals(0, seatsMap.countSeats(SeatsMap.OCCUPIED));

        int count = 0;
        while (!seatsMap.applyRules(true)) {
            count++;
        }

        assertEquals(6, count);
        assertEquals(26, seatsMap.countSeats(SeatsMap.OCCUPIED));
    }
}
