package com.connorcode.state;

import com.connorcode.state.scrappers.FavColor;
import com.connorcode.state.scrappers.FavEgg;
import com.connorcode.state.scrappers.Name;
import com.connorcode.state.scrappers.NameTitle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class StateMachine {
    public static HashMap<Keys, List<String>> state = new HashMap<>();
    static StateScrapper[] scrappers = new StateScrapper[]{
            new Name(),
            new NameTitle(),
            new FavColor(),
            new FavEgg()
    };

    public static void update(Keys key, String value) {
//        System.out.printf("UPDATE: %s => %s\n", key, value);
        List<String> values = state.getOrDefault(key, new ArrayList<>());
        values.add(value);
        state.put(key, values);
    }

    public static Optional<String> get(Keys key) {
        List<String> thisState = state.get(key);
        if (thisState.size() == 0) return Optional.empty();
        return Optional.of(thisState.get(thisState.size() - 1));
    }

    public static void scrape(String input) {
        for (StateScrapper i : scrappers) i.scrape(input);
    }

    public static List<Keys> noInfo() {
        List<Keys> out = new ArrayList<>(List.of(Keys.class.getEnumConstants()));
        for (Keys i : state.keySet()) out.remove(i);
        return out;
    }

    public enum Keys {
        Name,
        NameTitle,
        FavColor,
        FavEgg;

        public static String format(Keys key, String value) {
            return switch (key) {
                case Name -> "Your name is " + value;
                case FavColor -> "Your favorite color is " + value;
                case FavEgg -> "Your favorite way to prepare eggs is " + value;
                case NameTitle -> "Your title is " + value;
            };
        }
    }
}
