package com.connorcode.state.scrappers;

import com.connorcode.state.BasicScrapper;
import com.connorcode.state.StateMachine;

public class FavColor extends BasicScrapper {
    public FavColor() {
        this.key = StateMachine.Keys.FavColor;
        this.syntaxList = new String[]{
                "my favorite color is",
                "i like the color",
                };
    }

    @Override
    protected String getValue(String[] input, int startSyntax, int endSyntax, int syntax) {
        return input[endSyntax];
    }
}
