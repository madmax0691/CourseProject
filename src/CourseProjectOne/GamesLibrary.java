package CourseProjectOne;

import java.util.ArrayList;
import java.util.List;

public class GamesLibrary {
    private final List<Game> games = new ArrayList<>();

    public void addGame(Game game) {
        if (games.contains(game)) {
            throw new IllegalArgumentException("We have this game!");
        } else {
            games.add(game);
        }
    }

    public void removeGame(Game game) {
        if (games.contains(game)) {
            games.remove(game);
        } else {
            throw new IllegalArgumentException("We do not have this game!");
        }
    }

    public List<Game> getGames() {
        List<Game> tempGames = new ArrayList<>();
        tempGames.addAll(0, games);
        return tempGames;
    }

    public Game getGameByName(String name) {//temporal
        for (Game game : games) {
            if (game.getTitle().equals(name)) {
                return game;
            }
        }
        return null;
    }
}
