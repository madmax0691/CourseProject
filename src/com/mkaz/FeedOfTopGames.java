package com.mkaz;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FeedOfTopGames implements Feed {
    private final List<Game> feed;

    public FeedOfTopGames(GamesLibrary gamesLibrary) {
        feed = gamesLibrary.getGames();
        feed.sort(new Comparator<Game>() {
            @Override
            public int compare(Game o1, Game o2) {
                return Double.compare(o1.getAverageRating(), o2.getAverageRating());
            }
        });
        Collections.reverse(feed);
    }

    @Override
    public List<Game> getFeed() {
        return feed;
    }

    @Override
    public Game getGame(int number) {
        return feed.get(number);
    }
}
