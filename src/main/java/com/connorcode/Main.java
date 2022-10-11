package com.connorcode;

import com.connorcode.misc.Response;

import java.util.Scanner;

class Main {
    public static void main(String[] argv) {
        Scanner in = new Scanner(System.in);

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
                case None -> System.out.println("NO RESPONSE");
            }
        }
    }
}