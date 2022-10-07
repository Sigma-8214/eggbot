package com.connorcode.misc;

import java.util.List;

public abstract class BasicComponent implements ChatComponent {
    public KeyWord[] keyWords;

    @Override
    public double scoreText(String input) {
        double out = 0.0;
        double totalWeight = 0.0;
        List<String> words = List.of(input.split(" "));

        for (KeyWord i : keyWords) totalWeight += i.weight;

        for (KeyWord i : keyWords) {
            for (String j : words) {
                double similarity = Common.diceCoefficient(i.word, j);
                if (similarity >= 0.80) {
                    out += i.weight / totalWeight * similarity;
                    break;
                }
            }
        }

        return out;
    }

    public static class KeyWord {
        String word;
        double weight;

        public KeyWord(String word, double weight) {
            this.word = word;
            this.weight = weight;
        }
    }
}
