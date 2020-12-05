package com.bearsacker.adventofcode20.day2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PasswordPolicyTest {

    @Test
    public void firstPasswordPolicyTest() {
        FirstPolicy p = new FirstPolicy('a', 1, 3);
        FirstPolicy p1 = new FirstPolicy('b', 1, 3);
        FirstPolicy p2 = new FirstPolicy('c', 2, 9);

        assertEquals(true, p.checkPassword("abcde"));
        assertEquals(false, p1.checkPassword("cdefg"));
        assertEquals(true, p2.checkPassword("ccccccccc"));
    }

    @Test
    public void secondPasswordPolicyTest() {
        SecondPolicy p = new SecondPolicy('a', 1, 3);
        SecondPolicy p1 = new SecondPolicy('b', 1, 3);
        SecondPolicy p2 = new SecondPolicy('c', 2, 9);

        assertEquals(true, p.checkPassword("abcde"));
        assertEquals(false, p1.checkPassword("cdefg"));
        assertEquals(false, p2.checkPassword("ccccccccc"));
    }

}
