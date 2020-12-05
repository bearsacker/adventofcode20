package com.bearsacker.adventofcode20.day5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoardingPass implements Comparable<BoardingPass> {

    private final static int MAX_ROWS = 128;

    private final static int MAX_COLUMNS = 8;

    private final static Pattern REGEX = Pattern.compile("([FB]{7})([LR]*)");

    private int row;

    private int column;

    public BoardingPass(String rawData) {
        Matcher matcher = REGEX.matcher(rawData);
        if (matcher.matches()) {
            int minRow = 0;
            int maxRow = MAX_ROWS - 1;

            String rowSequence = matcher.group(1);
            for (int i = 0; i < rowSequence.length(); i++) {
                if (rowSequence.charAt(i) == 'F') {
                    maxRow -= (maxRow - minRow) / 2;
                } else {
                    minRow += (maxRow - minRow + 1) / 2;
                }
            }

            row = minRow;

            String columnSequence = matcher.group(2);
            if (columnSequence != null) {
                int minColumn = 0;
                int maxColumn = MAX_COLUMNS - 1;

                for (int i = 0; i < columnSequence.length(); i++) {
                    if (columnSequence.charAt(i) == 'L') {
                        maxColumn -= (maxColumn - minColumn) / 2;
                    } else {
                        minColumn += (maxColumn - minColumn) / 2;
                    }
                }

                column = maxColumn;
            }
        }
    }

    public int getSeatId() {
        return row * MAX_COLUMNS + column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public int compareTo(BoardingPass other) {
        return Integer.compare(getSeatId(), other.getSeatId());
    }

    @Override
    public String toString() {
        return "row " + row + ", column " + column + ", seat ID " + getSeatId();
    }
}
