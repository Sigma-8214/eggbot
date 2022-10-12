package com.connorcode;

import com.connorcode.chat.ChatComponent;
import com.connorcode.chat.Response;
import com.connorcode.chat.components.*;
import com.connorcode.state.StateMachine;

import java.util.Locale;
import java.util.Random;

public class ChatManager {
    public static Random rng = new Random();
    static ChatComponent[] components = new ChatComponent[]{
            new Egg(),
            new Pet(),
            new Greeting(),
            new Exit(),
            new WhatIKnow()
    };

    public static Response run(String input) {
        StateMachine.scrape(input);
        input = input.toLowerCase(Locale.ROOT);
        double maxScore = Double.MIN_VALUE;
        ChatComponent cmp = null;

        for (ChatComponent i : components) {
            double score = i.scoreText(input);
            if (score > maxScore) {
                maxScore = score;
                cmp = i;
            }
        }

        if (cmp == null || maxScore < 0.3)
            return new Response(Response.ResponseType.None, null);
        return cmp.process(input);
    }
}
