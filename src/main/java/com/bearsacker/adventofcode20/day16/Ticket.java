package com.bearsacker.adventofcode20.day16;

import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ticket {

    private final static Pattern REGEX_TICKET = Pattern.compile("(,|^)([0-9]+)");

    private ArrayList<Long> values;

    public static List<Ticket> parse(List<String> lines) {
        return lines.stream().map(x -> {
            Matcher matcher = REGEX_TICKET.matcher(x);
            ArrayList<Long> values = new ArrayList<>();
            while (matcher.find()) {
                values.add(parseLong(matcher.group(2)));
            }

            return new Ticket(values);
        }).filter(x -> !x.isEmpty()).collect(Collectors.toList());
    }

    public Ticket(ArrayList<Long> values) {
        this.values = values;
    }

    public Long getErrorValue(List<Field> fields) {
        for (Long value : values) {
            if (!fields.stream().anyMatch(x -> x.isValid(value))) {
                return value;
            }
        }

        return 0L;
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public Long getField(int fieldPosition) {
        return values.get(fieldPosition);
    }

    public Long getField(Field field) {
        return values.get(field.getPosition());
    }

    public int getValuesNumber() {
        return values.size();
    }
}
