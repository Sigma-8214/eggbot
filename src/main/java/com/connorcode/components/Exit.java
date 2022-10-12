package com.connorcode.components;

import com.connorcode.misc.BasicComponent;
import com.connorcode.misc.Response;

public class Exit extends BasicComponent {
    public Exit() {
        this.keyWords = new KeyWord[]{
                new KeyWord("exit", 0.7),
                new KeyWord("eggit", 0.7),
                new KeyWord("go", 0.5),
                new KeyWord("away", 0.6),
                new KeyWord("good", 0.1),
                new KeyWord("bye", 0.5),
                new KeyWord("goodbye", 0.6),
                new KeyWord("please", 0.2),

                };
    }

    @Override
    public Response process(String input) {
        return new Response(Response.ResponseType.Exit, "Oh ok.");
    }
}
