package com.bearsacker.adventofcode20.day17;

import static java.lang.Integer.compare;

import java.util.HashMap;
import java.util.List;

import com.bearsacker.utils.Interval;
import com.bearsacker.utils.Vec4;

public class Pocket4Dimension {

    private HashMap<Vec4, Cube> cubes;

    private Interval<Integer> xInterval;

    private Interval<Integer> yInterval;

    private Interval<Integer> zInterval;

    private Interval<Integer> wInterval;

    public Pocket4Dimension(List<String> lines) {
        cubes = new HashMap<>();

        int height = lines.size();
        int width = lines.get(0).length();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cubes.put(new Vec4(j, i, 0, 0), new Cube(lines.get(i).charAt(j) == '#'));
            }
        }

        xInterval = new Interval<>(0, width - 1);
        yInterval = new Interval<>(0, height - 1);
        zInterval = new Interval<>(0, 0);
        wInterval = new Interval<>(0, 0);
    }

    public void applyRules() {
        for (int x = xInterval.getMin() - 1; x <= xInterval.getMax() + 1; x++) {
            for (int y = yInterval.getMin() - 1; y <= yInterval.getMax() + 1; y++) {
                for (int z = zInterval.getMin() - 1; z <= zInterval.getMax() + 1; z++) {
                    for (int w = wInterval.getMin() - 1; w <= wInterval.getMax() + 1; w++) {
                        Vec4 position = new Vec4(x, y, z, w);
                        if (!cubes.containsKey(position)) {
                            cubes.put(position, new Cube(false));
                        }
                    }
                }
            }
        }

        int minX = cubes.keySet().stream().map(x -> x.x).min((a, b) -> compare(a, b)).orElse(0);
        int maxX = cubes.keySet().stream().map(x -> x.x).max((a, b) -> compare(a, b)).orElse(0);
        xInterval.setMin(minX);
        xInterval.setMax(maxX);

        int minY = cubes.keySet().stream().map(x -> x.y).min((a, b) -> compare(a, b)).orElse(0);
        int maxY = cubes.keySet().stream().map(x -> x.y).max((a, b) -> compare(a, b)).orElse(0);
        yInterval.setMin(minY);
        yInterval.setMax(maxY);

        int minZ = cubes.keySet().stream().map(x -> x.z).min((a, b) -> compare(a, b)).orElse(0);
        int maxZ = cubes.keySet().stream().map(x -> x.z).max((a, b) -> compare(a, b)).orElse(0);
        zInterval.setMin(minZ);
        zInterval.setMax(maxZ);

        int minW = cubes.keySet().stream().map(x -> x.z).min((a, b) -> compare(a, b)).orElse(0);
        int maxW = cubes.keySet().stream().map(x -> x.z).max((a, b) -> compare(a, b)).orElse(0);
        wInterval.setMin(minW);
        wInterval.setMax(maxW);

        HashMap<Vec4, Cube> cubes = new HashMap<>();

        this.cubes.entrySet().forEach(x -> {
            int neighbors = countActiveNeighbors(x.getKey());
            cubes.put(x.getKey(), new Cube(neighbors == 3 || (isCubeActive(x.getKey()) && neighbors == 2)));
        });

        this.cubes = cubes;
    }

    public boolean isCubeActive(Vec4 position) {
        if (cubes.containsKey(position)) {
            return cubes.get(position).isActive();
        }

        return false;
    }

    public long countActiveCubes() {
        return cubes.entrySet().stream().filter(x -> x.getValue().isActive()).count();
    }

    private int countActiveNeighbors(Vec4 position) {
        int count = 0;

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    for (int w = -1; w <= 1; w++) {
                        if (x != 0 || y != 0 || z != 0 || w != 0) {
                            Vec4 diff = new Vec4(position.x + x, position.y + y, position.z + z, position.w + w);
                            count += isCubeActive(diff) ? 1 : 0;
                        }
                    }
                }
            }
        }

        return count;
    }
}
