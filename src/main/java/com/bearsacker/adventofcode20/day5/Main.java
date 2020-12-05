package com.bearsacker.adventofcode20.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        ArrayList<BoardingPass> boardingPass = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("day5/input.txt"));
        reader.lines().forEach(x -> boardingPass.add(new BoardingPass(x)));
        reader.close();

        Collections.sort(boardingPass);
        Collections.reverse(boardingPass);

        System.out.println("Part 1: " + boardingPass.get(0));

        Collections.reverse(boardingPass);

        int yourSeatId = 0;
        for (int i = 0; i < boardingPass.size() - 2; i += 2) {
            int diff = boardingPass.get(i + 1).getSeatId() - boardingPass.get(i).getSeatId();
            if (diff == 2) {
                yourSeatId = boardingPass.get(i).getSeatId() + 1;
                break;
            }
        }

        System.out.println("Part 2: " + yourSeatId);
    }

}
