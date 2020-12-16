package com.bearsacker.adventofcode20.day16;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TicketTest {

    @Test
    public void parseFieldsAndTicketsTest() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("class: 1-3 or 5-7");
        lines.add("row: 6-11 or 33-44");
        lines.add("seat: 13-40 or 45-50");
        lines.add("");
        lines.add("your ticket:");
        lines.add("7,1,14");
        lines.add("");
        lines.add("nearby tickets:");
        lines.add("7,3,47");
        lines.add("40,4,50");
        lines.add("55,2,20");
        lines.add("38,6,12");

        List<Field> fields = Field.parse(lines);
        List<Ticket> tickets = Ticket.parse(lines);
        tickets.remove(0);

        assertEquals(71L, Day16.getErrorValuesCount(fields, tickets).longValue());
    }

    @Test
    public void findFieldsTest() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("class: 0-1 or 4-19");
        lines.add("row: 0-5 or 8-19");
        lines.add("seat: 0-13 or 16-19");
        lines.add("");
        lines.add("your ticket:");
        lines.add("11,12,13");
        lines.add("");
        lines.add("nearby tickets:");
        lines.add("3,9,18");
        lines.add("15,1,5");
        lines.add("5,14,9");

        List<Field> fields = Field.parse(lines);
        List<Ticket> tickets = Ticket.parse(lines);
        Ticket yourTicket = tickets.get(0);
        tickets.remove(0);

        Day16.findFieldsPosition(fields, tickets, yourTicket);
        assertEquals(0, fields.get(1).getPosition().intValue());
        assertEquals(1, fields.get(0).getPosition().intValue());
        assertEquals(2, fields.get(2).getPosition().intValue());
    }

}
