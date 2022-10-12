package com.connorcode.state.scrappers;

import com.connorcode.state.BasicScrapper;
import com.connorcode.state.StateMachine;

public class FavEgg extends BasicScrapper {
    public FavEgg() {
        this.key = StateMachine.Keys.FavEgg;
        this.syntaxList = new String[]{
                "my favorite kind of egg is",
                "i like my eggs"
        };
    }

    @Override
    protected String getValue(String[] input, int startSyntax, int endSyntax, int syntax) {
        return input[endSyntax];
    }
}
