package com.connorcode;

import com.connorcode.chat.Response;

import java.util.Scanner;

class Main {
    static String[] randomResponses = new String[]{
            "coooool - like an egg",
            "idk what that means",
            "how about you talk about somthing more egg",
            "so, um, the weather is nice today",
            "whats your view on egg",
            "Nice to see you"
    };

    public static void main(String[] argv) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hi, Im dieggo!");

        while (true) {
            System.out.print("[EGGBOT]> ");
            String text = in.nextLine();
            Response res = ChatManager.run(text);
            switch (res.type) {
                case BasicText -> System.out.println((String) res.value);
                case Exit -> {
                    System.out.println((String) res.value);
                    System.exit(0);
                }
                case None -> System.out.println(randomResponses[ChatManager.rng.nextInt(randomResponses.length)]);
            }
        }
    }
}