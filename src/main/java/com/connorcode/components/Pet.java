package com.connorcode.components;

import com.connorcode.misc.BasicComponent;
import com.connorcode.misc.Response;

public class Pet extends BasicComponent {
    public Pet() {
        this.keyWords = new KeyWord[]{
                new KeyWord("pet", 1.0),
                new KeyWord("cat", 0.7),
                new KeyWord("dog", 0.7),
                new KeyWord("fish", 0.7),
        };
    }

    @Override
    public Response process(String input) {
        return new Response(Response.ResponseType.BasicText, "PET RESPONSE");
    }
}
