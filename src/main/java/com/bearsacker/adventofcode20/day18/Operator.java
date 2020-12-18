package com.bearsacker.adventofcode20.day18;

public enum Operator {
    ADD("+", 0, new Computable() {

        @Override
        public long operate(long left, long right) {
            return left + right;
        }
    }), //
    MUL("*", 1, new Computable() {

        @Override
        public long operate(long left, long right) {
            return left * right;
        }
    });

    public final static int MIN_PRECEDENCE = 0;

    public final static int MAX_PRECEDENCE = 1;

    public String symbol;

    public int precedence;

    public Computable operate;

    private Operator(String symbol, int precedence, Computable operate) {
        this.symbol = symbol;
        this.precedence = precedence;
        this.operate = operate;
    }

    public long operate(long left, long right) {
        return operate.operate(left, right);
    }

    public static Operator find(String symbol) {
        for (Operator operator : Operator.values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }

        return null;
    }
}
