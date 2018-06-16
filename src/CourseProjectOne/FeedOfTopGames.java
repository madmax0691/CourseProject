package CourseProjectOne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FeedOfTopGames implements Feed {
    private final ArrayList<Game> feed;

    public FeedOfTopGames(GamesLibrary gamesLibrary) {
        feed = gamesLibrary.getGames();
        Collections.sort(feed, new Comparator<Game>() {
            @Override
            public int compare(Game o1, Game o2) {
                return Double.compare(o1.getAverageRating(), o2.getAverageRating());
            }
        });
        Collections.reverse(feed);
    }

    @Override
    public void showFeed(int page) {
        int amountOfGamesOnPage = 9;
        if (page < 1 || page * amountOfGamesOnPage - amountOfGamesOnPage > feed.size()) {
            throw new IllegalArgumentException("Try another page");
        } else {
            if (feed.size() > page * amountOfGamesOnPage) {
                for (int i = (page * amountOfGamesOnPage) - amountOfGamesOnPage; i < page * amountOfGamesOnPage; i++) {
                    System.out.println("#" + i + ": " + feed.get(i));
                }
            } else {
                for (int i = (page * amountOfGamesOnPage) - amountOfGamesOnPage; i < feed.size(); i++) {
                    System.out.println("#" + i + ": " + feed.get(i));
                }
            }
        }
    }

    @Override
    public Game getGame(int number) {
        return feed.get(number);
    }
}
