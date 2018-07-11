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
//Test
//Done! GOD OF WAR
//Done! Injustice 2
//Done! DARK SOULS REMASTERED
//Done! BATMAN: THE ENEMY WITHIN
//Done! FROSTPUNK
//Done! THE ELDER SCROLLS ONLINE: SUMMERSET
//Done! THE FOREST
//Done! FAR CRY 5
//Done! DRAGON'S CROWN PRO
//Done! FAR: LONE SAILS
//Done! OUTLAST 2
//Done! BATTLETECH
//Game{title='GOD OF WAR', releaseYear=2018-04-20, genre='Action Adventure', platform='PS4', averageRating=0.0, favoritesCounter=0}
//Game{title='Injustice 2', releaseYear=2018-03-27, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}
//
//Process finished with exit code 0