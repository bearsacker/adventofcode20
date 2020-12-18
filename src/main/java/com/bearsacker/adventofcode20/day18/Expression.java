package com.bearsacker.adventofcode20.day18;

import static com.bearsacker.adventofcode20.day18.Operator.MAX_PRECEDENCE;
import static com.bearsacker.adventofcode20.day18.Operator.MIN_PRECEDENCE;
import static java.lang.Long.parseLong;
import static java.util.Arrays.asList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {

    private static final Pattern REGEX_EXPRESSION = Pattern.compile("(\\(([^\\(\\)]+)\\))");

    private static final Pattern REGEX_VARIABLE = Pattern.compile("(var[0-9]+)");

    private LinkedList<String> expressions;

    private HashMap<String, Long> registry;

    public Expression(String expression) {
        expressions = new LinkedList<>();
        registry = new HashMap<>();

        Matcher matcher = REGEX_EXPRESSION.matcher(expression);
        while (matcher.find()) {
            expressions.add(matcher.group(2));

            expression = replaceExpression(expression, matcher.start(2) - 1, matcher.end(2) + 1, "var" + expressions.size());
            matcher = REGEX_EXPRESSION.matcher(expression);
        }

        expressions.add(expression);
    }

    private String replaceExpression(String expression, int start, int end, String value) {
        return expression.substring(0, start) + value + expression.substring(end);
    }

    public LinkedList<String> getExpressions() {
        return expressions;
    }

    public long compute(boolean withPrecedence) {
        long result = 0;

        for (int i = 0; i < expressions.size(); i++) {
            String expression = expressions.get(i);
            result = compute(expression, withPrecedence);

            registry.put("var" + (i + 1), result);
        }

        return result;
    }

    private long compute(String expression, boolean withPrecedence) {
        Matcher matcher = REGEX_VARIABLE.matcher(expression);
        while (matcher.find()) {
            expression = replaceExpression(expression, matcher.start(0), matcher.end(0),
                    Long.toString(registry.get(matcher.group(0))));

            matcher = REGEX_VARIABLE.matcher(expression);
        }

        LinkedList<String> values = new LinkedList<>(asList(expression.split(" ")));
        for (int precedence = MIN_PRECEDENCE; precedence <= MAX_PRECEDENCE && values.size() > 1; precedence++) {
            for (int i = 1; values.size() > 1 && i < values.size() - 1;) {
                Operator operator = Operator.find(values.get(i));
                if (operator != null && (!withPrecedence || operator.precedence == precedence)) {
                    long result = operator.operate(parseLong(values.get(i - 1)), parseLong(values.get(i + 1)));
                    values.set(i + 1, Long.toString(result));
                    values.remove(i);
                    values.remove(i - 1);

                    i = 1;
                } else {
                    i += 2;
                }
            }
        }

        return parseLong(values.getFirst());
    }
}
