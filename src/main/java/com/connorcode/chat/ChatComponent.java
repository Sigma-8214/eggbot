package com.connorcode.chat;

public interface ChatComponent {
    double scoreText(String input);

    Response process(String input);
}
