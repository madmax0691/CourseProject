package com.mkaz.sort;

import com.mkaz.Game;

import java.util.Comparator;

public class NamesComparator implements Comparator<Game> {
    @Override
    public int compare(Game g1, Game g2) {
        return g1.getTitle().compareTo(g2.getTitle());
    }
}
