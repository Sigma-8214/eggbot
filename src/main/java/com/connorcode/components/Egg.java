package com.connorcode.components;

import com.connorcode.misc.ChatComponent;
import com.connorcode.misc.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Egg implements ChatComponent {
    static Random rng = new Random();

    @Override
    public double scoreText(String input) {
        String[] words = input.split(" ");

        for (String i : words) {
            if (i.contains("ex") && !i.endsWith("ex"))
                return Double.MAX_VALUE;
        }

        return 0;
    }

    @Override
    public Response process(String input) {
        String[] words = input.split(" ");
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
