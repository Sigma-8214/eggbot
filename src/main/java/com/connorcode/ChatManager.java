package com.connorcode;

import com.connorcode.components.Egg;
import com.connorcode.components.Exit;
import com.connorcode.components.Greeting;
import com.connorcode.components.Pet;
import com.connorcode.misc.ChatComponent;
import com.connorcode.misc.Common;
import com.connorcode.misc.Response;

import java.util.Locale;
import java.util.Random;

public class ChatManager {
    public static Random rng = new Random();
    static ChatComponent[] components = new ChatComponent[]{
            new Egg(),
            new Pet(),
            new Greeting(),
            new Exit()
    };

    public static Response run(String input) {
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

        if (cmp == null)
            return new Response(Response.ResponseType.None, null);
        return cmp.process(input);
    }
}
