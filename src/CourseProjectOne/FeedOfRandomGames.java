package CourseProjectOne;

import java.util.ArrayList;
import java.util.Collections;

public class FeedOfRandomGames implements Feed {
    private final ArrayList<Game> feed;

    public FeedOfRandomGames(GamesLibrary gamesLibrary) {
        feed = gamesLibrary.getGames();
        Collections.shuffle(feed);
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
