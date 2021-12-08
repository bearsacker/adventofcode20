package com.bearsacker.adventofcode20.day17;

import static java.lang.Integer.compare;

import java.util.HashMap;
import java.util.List;

import com.bearsacker.utils.Interval;
import com.bearsacker.utils.Vec3;

public class PocketDimension {

    private HashMap<Vec3, Cube> cubes;

    private Interval<Integer> xInterval;

    private Interval<Integer> yInterval;

    private Interval<Integer> zInterval;

    public PocketDimension(List<String> lines) {
        cubes = new HashMap<>();

        int height = lines.size();
        int width = lines.get(0).length();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cubes.put(new Vec3(j, i, 0), new Cube(lines.get(i).charAt(j) == '#'));
            }
        }

        xInterval = new Interval<>(0, width - 1);
        yInterval = new Interval<>(0, height - 1);
        zInterval = new Interval<>(0, 0);
    }

    public void applyRules() {
        for (int x = xInterval.getMin() - 1; x <= xInterval.getMax() + 1; x++) {
            for (int y = yInterval.getMin() - 1; y <= yInterval.getMax() + 1; y++) {
                for (int z = zInterval.getMin() - 1; z <= zInterval.getMax() + 1; z++) {
                    Vec3 position = new Vec3(x, y, z);
                    if (!cubes.containsKey(position)) {
                        cubes.put(position, new Cube(false));
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

        HashMap<Vec3, Cube> cubes = new HashMap<>();

        this.cubes.entrySet().forEach(x -> {
            int neighbors = countActiveNeighbors(x.getKey());
            cubes.put(x.getKey(), new Cube(neighbors == 3 || (isCubeActive(x.getKey()) && neighbors == 2)));
        });

        this.cubes = cubes;
    }

    public boolean isCubeActive(Vec3 position) {
        if (cubes.containsKey(position)) {
            return cubes.get(position).isActive();
        }

        return false;
    }

    public long countActiveCubes() {
        return cubes.entrySet().stream().filter(x -> x.getValue().isActive()).count();
    }

    private int countActiveNeighbors(Vec3 position) {
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    if (i != 0 || j != 0 || k != 0) {
                        Vec3 diff = new Vec3(position.x + i, position.y + j, position.z + k);
                        count += isCubeActive(diff) ? 1 : 0;
                    }
                }
            }
        }

        return count;
    }

    @Override
    public String toString() {
        String result = "";

        for (int z = zInterval.getMin(); z <= zInterval.getMax(); z++) {
            result += "z=" + z + "\n";

            for (int y = yInterval.getMin(); y <= yInterval.getMax(); y++) {
                for (int x = xInterval.getMin(); x <= xInterval.getMax(); x++) {
                    Vec3 position = new Vec3(x, y, z);
                    if (cubes.containsKey(position)) {
                        result += cubes.get(position).isActive() ? "#" : ".";
                    } else {
                        result += "G";
                    }
                }

                result += "\n";
            }
        }

        return result;
    }

}
