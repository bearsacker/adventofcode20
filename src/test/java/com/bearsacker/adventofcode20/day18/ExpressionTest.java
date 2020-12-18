package com.bearsacker.adventofcode20.day18;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExpressionTest {

    @Test
    public void parseTest() {
        String expressionRaw = "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2";

        Expression expression = new Expression(expressionRaw);
        assertEquals(4, expression.getExpressions().size());
        assertEquals("var3 + 2 + 4 * 2", expression.getExpressions().getLast());
    }

    @Test
    public void computeWithoutPrecedenceTest() {
        assertEquals(26, new Expression("2 * 3 + (4 * 5)").compute(false));
        assertEquals(437, new Expression("5 + (8 * 3 + 9 + 3 * 4 * 3)").compute(false));
        assertEquals(12240, new Expression("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))").compute(false));
        assertEquals(13632, new Expression("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2").compute(false));
    }

    @Test
    public void computeWithPrecedenceTest() {
        assertEquals(51, new Expression("1 + (2 * 3) + (4 * (5 + 6))").compute(true));
        assertEquals(46, new Expression("2 * 3 + (4 * 5)").compute(true));
        assertEquals(1445, new Expression("5 + (8 * 3 + 9 + 3 * 4 * 3)").compute(true));
        assertEquals(669060, new Expression("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))").compute(true));
        assertEquals(23340, new Expression("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2").compute(true));
    }

}
