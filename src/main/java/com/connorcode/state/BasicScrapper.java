package com.connorcode.state;

import com.connorcode.Common;

import java.util.Locale;

public abstract class BasicScrapper implements StateScrapper {
    protected String[] syntaxList;
    protected StateMachine.Keys key;

    protected abstract String getValue(String[] input, int startSyntax, int endSyntax, int syntax);

    @Override
    public void scrape(String input) {
        String[] words = input.split(Common.wordSplit);

        for (int syntaxIndex = 0; syntaxIndex < syntaxList.length; syntaxIndex++) {
            String tmpSyntax = syntaxList[syntaxIndex];
            String[] syntax = tmpSyntax.split(Common.wordSplit);
            if (words.length - syntax.length <= 0) continue;

            // For each syntax starting pos
            pos:
            for (int s = 0; s < words.length - syntax.length; s++) {
                // For each word
                for (int i = 0; i < syntax.length; i++) {
                    if (Common.diceCoefficient(words[s + i].toLowerCase(Locale.ROOT), syntax[i]) < 0.85) continue pos;
                }

                // Run get value and store it in the StateMachine
                StateMachine.update(key, getValue(words, s, s + syntax.length, syntaxIndex));
                return;
            }
        }
    }
}
