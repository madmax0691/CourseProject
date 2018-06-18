package CourseProjectOne;

import java.util.ArrayList;
import java.util.List;

class GamesLibrary {
    private final List<Game> games = new ArrayList<>();

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

    List<Game> getGames() {
        List<Game> tempGames = new ArrayList<>();
        tempGames.addAll(0, games);
        return tempGames;
    }
}
