package com.connorcode.state;

import com.connorcode.state.scrappers.FavColor;
import com.connorcode.state.scrappers.FavEgg;
import com.connorcode.state.scrappers.Name;
import com.connorcode.state.scrappers.NameTitle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StateMachine {
    static StateScrapper[] scrappers = new StateScrapper[]{
            new Name(),
            new NameTitle(),
            new FavColor(),
            new FavEgg()
    };

    static HashMap<Keys, List<String>> state = new HashMap<>();

    public static void update(Keys key, String value) {
        System.out.printf("UPDATE: %s => %s\n", key, value);
        state.getOrDefault(key, new ArrayList<>())
                .add(value);
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
        FavEgg,
    }
}
