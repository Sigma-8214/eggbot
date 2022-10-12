package com.connorcode.chat.components;

import com.connorcode.Common;
import com.connorcode.chat.ChatComponent;
import com.connorcode.chat.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Egg implements ChatComponent {
    static Random rng = new Random();

    @Override
    public double scoreText(String input) {
        String[] words = input.split(Common.wordSplit);

        for (String i : words) {
            if (i.contains("ex") && !i.endsWith("ex"))
                return Double.MAX_VALUE;
        }

        return 0;
    }

    @Override
    public Response process(String input) {
        String[] words = input.split(Common.wordSplit);
        List<String> opportunities = new ArrayList<>();

        for (String i : words) {
            if (!i.contains("ex") || i.endsWith("ex")) continue;
            opportunities.add(i);
        }

        String randomEx = opportunities.get(rng.nextInt(opportunities.size()))
                .replace("ex", "egg");
        return new Response(Response.ResponseType.BasicText, String.format("You mean %s???", randomEx));
    }
}
