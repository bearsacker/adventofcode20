package com.bearsacker.adventofcode20.day01;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.bearsacker.adventofcode20.day01.Day1;

public class MainTest {

    @Test
    public void findTest() {
        List<Integer> numbers = asList(1721, 979, 366, 299, 675, 1456);

        assertEquals(514579, Day1.find(2020, numbers, 1));
        assertEquals(241861950, Day1.find(2020, numbers, 2));
    }

}
