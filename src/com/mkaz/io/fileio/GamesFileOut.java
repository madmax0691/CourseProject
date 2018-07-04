package com.mkaz.io.fileio;

import com.mkaz.Game;
import com.mkaz.GamesLibrary;

import java.util.Arrays;
import java.util.List;

public class GamesFileOut {
    private final StringBuilder stringBuilder = new StringBuilder();
    private final GamesLibrary gamesLibrary;

    public GamesFileOut(GamesLibrary gamesLibrary) {
        this.gamesLibrary = gamesLibrary;
    }

    private void addFirstLine() {
        stringBuilder.append("\"" + "Title:" + "\"" + "\t" + "\"" + "Description:" + "\"" + "\t" + "\"" + "ReleaseYear:"
                + "\"" + "\t" + "\"" + "Genre:" + "\"" + "\t" + "\"" + "Platform:" + "\"" + "\n");
    }

    private List<String> initialize() {
        addFirstLine();
        for (Game game : gamesLibrary.getGames()) {
            stringBuilder.append("\"");
            stringBuilder.append(game.getTitle());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(game.getDescription());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(game.getReleaseYear());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(game.getGenre());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(game.getPlatform());
            stringBuilder.append("\"");
            stringBuilder.append("\n");
        }
        return Arrays.asList(stringBuilder.toString().split("\n"));
    }

    public void write(String fileName) {
        TextFileIO.write(fileName, initialize());
    }
}
