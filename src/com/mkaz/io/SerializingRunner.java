package com.mkaz.io;

import com.mkaz.Game;
import com.mkaz.io.fileio.Formatter;
import com.mkaz.io.fileio.GamesFileIn;
import com.mkaz.io.fileio.TextFileIO;
import com.mkaz.io.serializing.Serializing;

import java.util.List;

public class SerializingRunner {
    public static void main(String[] args) {
        String gamesInfo = TextFileIO.read("files/games.csv", ",");
        Formatter gamesFormatter = new Formatter("csv", gamesInfo);
        GamesFileIn gamesFileIn = new GamesFileIn(gamesFormatter.getFormattedInfo());
        gamesFileIn.addAllGames();
        List<Game> games = gamesFileIn.getGamesLibrary().getGames();

        int counter = 0;
        for (Game game : games) {
            Serializing.write("files/serializing/" + "game" + counter + ".ser", game);
            counter++;
        }

        System.out.println(Serializing.read("files/serializing/game0.ser"));
        System.out.println(Serializing.read("files/serializing/game1.ser"));
    }
}
