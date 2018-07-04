package com.mkaz.io.fileio;

import com.mkaz.Game;
import com.mkaz.GamesLibrary;

import java.util.ArrayList;
import java.util.List;

public class GamesFileOut {
    private final GamesLibrary gamesLibrary;
    List<String> gamesInfo = new ArrayList<>();

    public GamesFileOut(GamesLibrary gamesLibrary) {
        this.gamesLibrary = gamesLibrary;
    }

    private void addFirstLine() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"" + "Title:" + "\"" + "\t" + "\"" + "Description:" + "\"" + "\t" + "\"" + "ReleaseYear:"
                + "\"" + "\t" + "\"" + "Genre:" + "\"" + "\t" + "\"" + "Platform:" + "\"" + "\n");
        gamesInfo.add(stringBuilder.toString());
    }

    private void initialize() {
        addFirstLine();
        StringBuilder stringBuilder;
        for (Game game : gamesLibrary.getGames()) {
            stringBuilder = new StringBuilder();
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
            gamesInfo.add(stringBuilder.toString());
        }
    }

    public void write(String fileName) {
        initialize();
        TextFileIO.write(fileName, gamesInfo);
    }
}
