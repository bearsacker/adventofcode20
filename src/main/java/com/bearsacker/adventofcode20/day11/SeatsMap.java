package com.bearsacker.adventofcode20.day11;

import java.util.ArrayList;
import java.util.List;

import com.bearsacker.utils.Vec2;

public class SeatsMap {

    public final static char FLOOR = '.';

    public final static char EMPTY = 'L';

    public final static char OCCUPIED = '#';

    private int width;

    private int height;

    private char[][] seats;

    public SeatsMap(List<String> lines) {
        height = lines.size();
        width = lines.get(0).length();
        seats = new char[width][height];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                seats[j][i] = lines.get(i).charAt(j);
            }
        }
    }

    public boolean applyRules(boolean propagate) {
        char[][] outputSeats = new char[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                outputSeats[i][j] = seats[i][j];

                if (seats[i][j] == EMPTY && findOccupiedAdjacents(i, j, propagate) == 0) {
                    outputSeats[i][j] = OCCUPIED;
                } else if (seats[i][j] == OCCUPIED && findOccupiedAdjacents(i, j, propagate) >= (propagate ? 5 : 4)) {
                    outputSeats[i][j] = EMPTY;
                }
            }
        }

        boolean equals = equals(outputSeats);
        seats = outputSeats;

        return equals;
    }

    private boolean equals(char[][] otherSeats) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (seats[i][j] != otherSeats[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public int findOccupiedAdjacents(int x, int y, boolean propagate) {
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    count += findOccupiedSeatIntoDirection(new Vec2(x, y), new Vec2(i, j), propagate) ? 1 : 0;
                }
            }
        }

        return count;
    }

    public boolean findOccupiedSeatIntoDirection(Vec2 position, Vec2 direction, boolean propagate) {
        position.add(direction);
        Character seat = getSeat(position.x, position.y);
        if (seat == null || seat == EMPTY) {
            return false;
        }

        do {
            if (seat == OCCUPIED) {
                return true;
            }
            position.add(direction);
            seat = getSeat(position.x, position.y);
        } while (propagate && seat != null && seat != EMPTY);

        return false;
    }

    public int countSeats(char type) {
        int count = 0;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                count += seats[i][j] == type ? 1 : 0;
            }
        }

        return count;
    }

    public Character getSeat(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return null;
        }

        return seats[x][y];
    }

    public List<String> getLines() {
        ArrayList<String> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            String line = "";
            for (int j = 0; j < width; j++) {
                line += seats[j][i];
            }
            lines.add(line);
        }

        return lines;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
