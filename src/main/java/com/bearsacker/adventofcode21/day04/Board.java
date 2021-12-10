package com.bearsacker.adventofcode21.day04;

import java.util.List;

public class Board {

    public final static int SIZE = 5;

    private String[][] cells;

    private boolean[][] marked;

    private boolean win;

    public Board(List<String> lines) {
        marked = new boolean[SIZE][SIZE];
        cells = new String[SIZE][SIZE];
        win = false;

        for (int i = 0; i < SIZE; i++) {
            cells[i] = lines.get(i).trim().split("\t|  | ");
        }
    }

    public void mark(int value) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (Integer.toString(value).equals(cells[i][j])) {
                    marked[i][j] = true;
                    checkWin(i, j);

                    break;
                }
            }
        }
    }

    public void checkWin(int x, int y) {
        boolean line = true;
        for (int i = 0; i < SIZE; i++) {
            if (marked[x][i] == false) {
                line = false;
                break;
            }
        }

        boolean column = true;
        for (int i = 0; i < SIZE; i++) {
            if (marked[i][y] == false) {
                column = false;
                break;
            }
        }

        win = column || line;
    }

    public boolean isWin() {
        return win;
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                score += !marked[i][j] ? Integer.parseInt(cells[i][j]) : 0;
            }
        }

        return score;
    }
}
