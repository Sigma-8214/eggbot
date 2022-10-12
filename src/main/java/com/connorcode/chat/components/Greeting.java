package com.connorcode.chat.components;

import com.connorcode.ChatManager;
import com.connorcode.chat.BasicComponent;
import com.connorcode.chat.Response;

public class Greeting extends BasicComponent {
    String[] feelingResponse = new String[]{
            "Im Good :P",
            "I am doing well.. Thanks for asking",
            "Not bad",
            "Could be bettor...",
            "✨",
            "╰(*°▽°*)╯",
            "Amazing!",
            "A bit slow...",
            "According to my lawyer I don’t have to answer that question",
            "I can’t complain. My contract actually forbids me",
            "Ready for a nap",
            "I hear good things. But I don’t think it’s smart to believe rumors",
            "How am I doing WHAT?",
            "I dunno. Is it almost the weekend?",
            "It’s a secret",
            "Pass. Next question, please",
            "Oh terrible, but I’m used to it"
    };
    String[] greetingResponse = new String[]{
            "Hi!",
            "Hola",
            "Glad to see you :P",
            "Nice seeing you here!"
    };

    public Greeting() {
        this.keyWords = new KeyWord[]{
                new KeyWord("hello", 0.7),
                new KeyWord("how", 0.2),
                new KeyWord("are", 0.2),
                new KeyWord("you", 0.2),
                new KeyWord("today", 0.2),
                new KeyWord("dieggo", 0.3)
        };
    }

    @Override
    public Response process(String input) {
        if (input.contains("how") || (input.contains("are") && input.contains("you"))) {
            String res = feelingResponse[ChatManager.rng.nextInt(feelingResponse.length)];
            return new Response(Response.ResponseType.BasicText,
                    String.format("%s%s", res, ChatManager.rng.nextBoolean() ? "\nWhat about you?" : ""));
        }
        return new Response(Response.ResponseType.BasicText,
                greetingResponse[ChatManager.rng.nextInt(greetingResponse.length)]);
    }
}
