package com.bearsacker.adventofcode20.day6;

import java.util.HashMap;

public class Group {

    private HashMap<Character, Integer> questions;

    private int numberPersons;

    public Group(String rawData) {
        questions = new HashMap<>();

        String[] values = rawData.split(" ");
        numberPersons = values.length - 1;

        for (String question : values) {
            for (int i = 0; i < question.length(); i++) {
                addQuestion(question.charAt(i));
            }
        }
    }

    private void addQuestion(char question) {
        if (questions.containsKey(question)) {
            questions.put(question, questions.get(question) + 1);
        } else {
            questions.put(question, 1);
        }
    }

    public int countsAnyone() {
        return questions.size();
    }

    public int countsEveryone() {
        return (int) questions.entrySet().stream().filter(x -> x.getValue() == numberPersons).count();
    }

}
