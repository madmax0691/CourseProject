package com.mkaz.sort;

import com.mkaz.Game;

import java.util.Comparator;

public class DateComparator implements Comparator<Game> {
    @Override
    public int compare(Game g1, Game g2) {
        return g1.getReleaseYear().compareTo(g2.getReleaseYear());
    }
}
