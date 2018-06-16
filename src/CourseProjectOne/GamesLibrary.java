package CourseProjectOne;

import java.util.ArrayList;

class GamesLibrary {
    private final ArrayList<Game> games = new ArrayList<>();

    void addGame(Game game) {
        if (games.contains(game)) {
            throw new IllegalArgumentException("We have this game!");
        } else {
            games.add(game);
        }
    }

    void removeGame(Game game) {
        if (games.contains(game)) {
            games.remove(game);
        } else {
            throw new IllegalArgumentException("We do not have this game!");
        }
    }

    ArrayList<Game> getGames() {
        return games;
    }
}
