package com.bearsacker.adventofcode20.day16;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.bearsacker.adventofcode20.utils.Interval;

public class Field {

    private final static Pattern REGEX_FIELDS = Pattern.compile("^([a-z ]+): ([0-9]+)-([0-9]+) or ([0-9]+)-([0-9]+)$");

    private String name;

    private List<Interval> intervals;

    private LinkedList<Integer> positions;

    public static List<Field> parse(List<String> lines) {
        return lines.stream().map(x -> {
            Matcher matcher = REGEX_FIELDS.matcher(x);
            if (matcher.matches()) {
                Interval i1 = new Interval(parseInt(matcher.group(2)), parseInt(matcher.group(3)));
                Interval i2 = new Interval(parseInt(matcher.group(4)), parseInt(matcher.group(5)));

                return new Field(matcher.group(1), asList(i1, i2));
            }

            return null;
        }).filter(x -> x != null).collect(Collectors.toList());
    }

    public Field(String name, List<Interval> intervals) {
        this.name = name;
        this.intervals = intervals;
        this.positions = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Interval> getIntervals() {
        return intervals;
    }

    public void setIntervals(List<Interval> intervals) {
        this.intervals = intervals;
    }

    public boolean isValid(Long value) {
        return intervals.stream().anyMatch(x -> x.isValueInto(value));
    }

    public Integer getPosition() {
        return positions.getFirst();
    }

    public void addPosition(int position) {
        positions.add(position);
    }

    public void removePosition(Integer position) {
        positions.remove(position);
    }

    public boolean isPositioned() {
        return positions.size() == 1;
    }
}
