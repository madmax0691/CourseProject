package com.mkaz.sort;

import com.mkaz.Game;

import java.time.LocalDate;
import java.util.Comparator;

public class DateComparator implements Comparator<Game> {
    @Override
    public int compare(Game g1, Game g2) {
        return LocalDate.parse(g1.getReleaseYear()).compareTo(LocalDate.parse(g2.getReleaseYear()));
    }
}
