package com.mkaz.filter;

import com.mkaz.Game;

import java.util.function.Predicate;

public class NamePredicate implements Predicate<Game> {
    private final char aChar;

    public NamePredicate(char aChar) {
        this.aChar = aChar;
    }

    @Override
    public boolean test(Game game) {
        return game.getTitle().charAt(0) == aChar;
    }
}