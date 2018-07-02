package com.mkaz;

import java.util.Collections;
import java.util.List;

public class FeedOfRandomGames implements Feed {
    private final List<Game> feed;

    public FeedOfRandomGames(GamesLibrary gamesLibrary) {
        feed = gamesLibrary.getGames();
        Collections.shuffle(feed);
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
