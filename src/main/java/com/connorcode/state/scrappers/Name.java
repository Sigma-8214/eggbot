package com.connorcode.state.scrappers;

import com.connorcode.state.BasicScrapper;
import com.connorcode.state.StateMachine;

public class Name extends BasicScrapper {
    public Name() {
        this.key = StateMachine.Keys.Name;
        this.syntaxList = new String[]{
                "my name is",
                "im",
                "i am",
                "you can call me",
                };
    }

    @Override
    public String getValue(String[] input, int startSyntax, int endSyntax, int syntax) {
        return input[endSyntax];
    }
}
