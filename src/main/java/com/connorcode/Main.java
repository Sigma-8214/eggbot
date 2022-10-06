package com.connorcode;

import com.connorcode.misc.Common;

import java.util.Scanner;

class Main {
    public static void main(String[] argv) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("[EGGBOT]> ");
            String text = in.nextLine();
            System.out.println(Common.diceCoefficient("mango", text));
        }
    }
}