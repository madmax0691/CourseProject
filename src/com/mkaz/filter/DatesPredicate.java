package com.mkaz.filter;

import com.mkaz.Game;

import java.time.LocalDate;
import java.util.function.Predicate;

public class DatesPredicate implements Predicate<Game> {
    private final LocalDate minDate;
    private final LocalDate maxDate;

    public DatesPredicate(LocalDate minDate, LocalDate maxDate) {
        this.minDate = minDate;
        this.maxDate = maxDate;
    }

    @Override
    public boolean test(Game game) {
        return game.getReleaseYear().isBefore(maxDate) && game.getReleaseYear().isAfter(minDate);
    }
}
