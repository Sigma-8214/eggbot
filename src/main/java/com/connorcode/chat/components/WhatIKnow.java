package com.connorcode.chat.components;

import com.connorcode.ChatManager;
import com.connorcode.chat.BasicComponent;
import com.connorcode.chat.Response;
import com.connorcode.state.StateMachine;

public class WhatIKnow extends BasicComponent {
    String[] noneResponses = new String[]{
            "I dont know anything!?",
            "~ everything ~"
    };

    public WhatIKnow() {
        this.keyWords = new KeyWord[]{
                new KeyWord("what", 0.1),
                new KeyWord("do", 0.1),
                new KeyWord("you", 0.1),
                new KeyWord("know", 0.5),
                new KeyWord("about", 0.1),
                new KeyWord("me", 0.3),
            };
    }

    @Override
    public Response process(String input) {
        System.out.println(StateMachine.state);

        // Respond if we know *nothing*
        if (StateMachine.state.isEmpty()) return new Response(Response.ResponseType.BasicText,
                noneResponses[ChatManager.rng.nextInt(noneResponses.length)]);

        StringBuilder out = new StringBuilder();
        for (StateMachine.Keys i : StateMachine.state.keySet()) {
            out.append(StateMachine.Keys.format(i, StateMachine.get(i)
                    .orElseThrow()));
            out.append("\n");
        }

        String resText = out.toString();
        return new Response(Response.ResponseType.BasicText, resText.substring(0, resText.length() - 1));
    }
}
