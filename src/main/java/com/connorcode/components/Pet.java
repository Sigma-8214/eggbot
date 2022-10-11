package com.connorcode.components;

import com.connorcode.ChatManager;
import com.connorcode.misc.BasicComponent;
import com.connorcode.misc.Response;

public class Pet extends BasicComponent {
    String[] petResponse = new String[]{
            "I love pets!",
            "I love animals!",
            "awww!"
    };

    public Pet() {
        this.keyWords = new KeyWord[]{
                new KeyWord("pet", 0.8),
                new KeyWord("cat", 0.7),
                new KeyWord("dog", 0.7),
                new KeyWord("fish", 0.7),
                new KeyWord("parrot", 0.7),
                new KeyWord("bird", 0.7),
                new KeyWord("goldfish", 0.7),
                new KeyWord("puppy", 0.7),
                new KeyWord("kitty", 0.7),
                new KeyWord("frog", 0.7),
        };
    }

    @Override
    public Response process(String input) {
        return new Response(Response.ResponseType.BasicText, petResponse[ChatManager.rng.nextInt(petResponse.length)]);
    }
}
