package com.connorcode;

import com.connorcode.components.Egg;
import com.connorcode.components.Pet;
import com.connorcode.misc.ChatComponent;
import com.connorcode.misc.Response;

public class ChatManager {
    static ChatComponent[] components = new ChatComponent[]{
            new Egg(),
            new Pet()
    };

    public static Response run(String input) {
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
