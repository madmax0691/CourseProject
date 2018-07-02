package com.mkaz;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FeedOfFavoritesGames implements Feed {
    private final List<Game> feed;

    public FeedOfFavoritesGames(GamesLibrary gamesLibrary) {
        feed = gamesLibrary.getGames();
        feed.sort(new Comparator<Game>() {
            @Override
            public int compare(Game o1, Game o2) {
                return Long.compare(o1.getFavoritesCounter(), o2.getFavoritesCounter());
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
