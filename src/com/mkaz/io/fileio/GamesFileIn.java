package com.mkaz.io.fileio;

import com.mkaz.Game;
import com.mkaz.GamesLibrary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GamesFileIn {
    private final GamesLibrary gamesLibrary = new GamesLibrary();

    public GamesFileIn(String fileName, String splitter, int numberOfColumns) {
        List<String> gamesInput = TextFileIO.read(fileName, splitter);

        removeTitles(gamesInput, numberOfColumns);
        initialize(gamesInput, numberOfColumns);
    }

    private void removeTitles(List<String> list, int numberOfColumns) {
        for (int i = 0; i < numberOfColumns; i++) {
            list.remove(0);
        }
    }

    private void initialize(List<String> list, int numberOfColumns) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");//Needs for reading date format
        for (int i = 0; i < list.size() / numberOfColumns; i++) {
            gamesLibrary.addGame(new Game(list.get(i * numberOfColumns), list.get(1 + i * numberOfColumns),
                    LocalDate.parse(list.get(2 + i * numberOfColumns), dateTimeFormatter),
                    list.get(3 + i * numberOfColumns), list.get(4 + i * numberOfColumns)));
        }
    }

    public GamesLibrary getGamesLibrary() {
        return gamesLibrary;
    }
}
