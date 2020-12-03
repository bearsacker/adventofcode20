package com.bearsacker.adventofcode20.day3;

import java.util.ArrayList;
import java.util.List;

public class Map {

    public final static char TREE = '#';

    private List<String> map;

    public Map(List<String> lines) {
        map = new ArrayList<String>(lines);
    }

    public int countTreesForDirection(Vec2 direction) {
        int countTrees = 0;

        Vec2 position = new Vec2(direction);
        while (position.y < getHeight()) {
            countTrees += getTile(position.x, position.y) ? 1 : 0;

            position.add(direction);
            if (position.x >= getWidth()) {
                position.x = position.x - getWidth();
            }
        }

        return countTrees;
    }

    public boolean getTile(int x, int y) {
        if (x >= 0 && y >= 0 && x < getWidth() && y < getHeight()) {
            return map.get(y).charAt(x) == TREE;
        }

        return false;
    }

    public int getWidth() {
        return map.get(0).length();
    }

    public int getHeight() {
        return map.size();
    }
}
