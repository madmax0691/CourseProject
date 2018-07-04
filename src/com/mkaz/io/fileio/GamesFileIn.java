package com.mkaz.io.fileio;

import com.mkaz.Game;
import com.mkaz.GamesLibrary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GamesFileIn {
    private final GamesLibrary gamesLibrary = new GamesLibrary();
    private static final int NUMBER_OF_COLUMNS = 5;
    private final List<String> gamesInfo;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");

    public GamesFileIn(List<String> gamesInfo) {
        this.gamesInfo = gamesInfo;
        removeTitles();
    }

    private void removeTitles() {
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            gamesInfo.remove(0);
        }
    }

    public void addAllGames() {
        for (int i = 0; i < gamesInfo.size() / NUMBER_OF_COLUMNS; i++) {
            gamesLibrary.addGame(new Game(gamesInfo.get(i * NUMBER_OF_COLUMNS), gamesInfo.get(1 + i * NUMBER_OF_COLUMNS),
                    LocalDate.parse(gamesInfo.get(2 + i * NUMBER_OF_COLUMNS), dateTimeFormatter),
                    gamesInfo.get(3 + i * NUMBER_OF_COLUMNS), gamesInfo.get(4 + i * NUMBER_OF_COLUMNS)));
        }
    }

    public GamesLibrary getGamesLibrary() {
        return gamesLibrary;
    }
}
