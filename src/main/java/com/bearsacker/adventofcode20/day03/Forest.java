package com.bearsacker.adventofcode20.day03;

import java.util.ArrayList;
import java.util.List;

import com.bearsacker.adventofcode20.utils.Vec2;

public class Forest {

    public final static char TREE = '#';

    private List<String> map;

    public Forest(List<String> lines) {
        map = new ArrayList<String>(lines);
    }

    public int countTreesForDirection(Vec2 direction) {
        int countTrees = 0;

        Vec2 position = new Vec2(direction);
        while (position.y < getHeight()) {
            countTrees += getTile(position.x, position.y) ? 1 : 0;

            position.add(direction);
            position.x %= getWidth();
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
        if (map.isEmpty()) {
            return 0;
        }

        return map.get(0).length();
    }

    public int getHeight() {
        return map.size();
    }
}
