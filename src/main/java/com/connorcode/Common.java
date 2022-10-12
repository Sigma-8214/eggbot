package com.connorcode;

import java.util.HashMap;

public class Common {
    public static final String wordSplit = "(?:(?<=^|[^a-zA-Z])'|'(?=[^a-zA-Z]|$)|[^a-zA-Z'])+";

    // DICE COEFFICIENT
    public static double diceCoefficient(String rawA, String rawB) {
        String a = rawA.replace(" ", "");
        String b = rawB.replace(" ", "");

        if (a.equals(b)) return 1.0;
        if (a.length() < 2 || b.length() < 2) return 0.0;

        HashMap<String, Integer> firstBigrams = new HashMap<>();
        for (int i = 0; i < a.length() - 1; i++) {
            String bigram = a.substring(i, i + 2);
            int count = firstBigrams.getOrDefault(bigram, 1);
            firstBigrams.put(bigram, count);
        }

        int intersectionSize = 0;
        for (int i = 0; i < b.length() - 1; i++) {
            String bigram = b.substring(i, i + 2);
            int count = firstBigrams.getOrDefault(bigram, 0);
            if (count <= 0) continue;
            firstBigrams.put(bigram, count - 1);
            intersectionSize++;
        }

        return 2.0 * intersectionSize / (a.length() + b.length() - 2);
    }
}
