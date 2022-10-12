package com.connorcode.state.scrappers;

import com.connorcode.Common;
import com.connorcode.state.StateMachine;
import com.connorcode.state.StateScrapper;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class NameTitle implements StateScrapper {
    String[] titles = new String[]{
            "mr",
            "ms",
            "mrs",
            "mx"
    };

    @Override
    public void scrape(String input) {
        List<String> words = Arrays.stream(input.split(Common.wordSplit))
                .map(x -> x.toLowerCase(Locale.ROOT))
                .toList();
        for (String i : words) {
            if (Arrays.stream(titles)
                    .toList()
                    .contains(i)) {
                StateMachine.update(StateMachine.Keys.NameTitle, i);
                break;
            }
        }
    }
}
