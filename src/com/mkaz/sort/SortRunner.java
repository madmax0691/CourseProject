package com.mkaz.sort;

import com.mkaz.Game;
import com.mkaz.io.fileio.Formatter;
import com.mkaz.io.fileio.GamesFileIn;
import com.mkaz.io.fileio.TextFileIO;

import java.util.List;

public class SortRunner {
    public static void main(String[] args) {
        String gamesInfo = TextFileIO.read("files/games.csv", ",");
        Formatter gamesFormatter = new Formatter("csv", gamesInfo);
        GamesFileIn gamesFileIn = new GamesFileIn(gamesFormatter.getFormattedInfo());
        gamesFileIn.addAllGames();
        List<Game> games = gamesFileIn.getGamesLibrary().getGames();

        games.sort(new NamesComparator());
        System.out.println(games);

        games.sort(new DateComparator().reversed());
        System.out.println(games);

        games.sort(new DateComparator().reversed().thenComparing(new NamesComparator()));
        System.out.println(games);
    }
}
//Test
//[Game{title='BATMAN: THE ENEMY WITHIN', releaseYear=2018-03-26, genre='Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='BATTLETECH', releaseYear=2018-04-24, genre='Strategy', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='DARK SOULS REMASTERED', releaseYear=2018-03-25, genre='Action RPG', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='DRAGON'S CROWN PRO', releaseYear=2018-05-15, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='FAR CRY 5', releaseYear=2018-03-27, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='FAR: LONE SAILS', releaseYear=2018-05-17, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='FROSTPUNK', releaseYear=2018-04-24, genre='Action Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='GOD OF WAR', releaseYear=2018-04-20, genre='Action Adventure', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='Injustice 2', releaseYear=2018-03-27, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='OUTLAST 2', releaseYear=2018-03-27, genre='Survival', platform='Switch', averageRating=0.0, favoritesCounter=0}, Game{title='THE ELDER SCROLLS ONLINE: SUMMERSET', releaseYear=2018-03-21, genre='Massively Multiplayer', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='THE FOREST', releaseYear=2018-04-30, genre='Horror', platform='PC', averageRating=0.0, favoritesCounter=0}]
//[Game{title='FAR: LONE SAILS', releaseYear=2018-05-17, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='DRAGON'S CROWN PRO', releaseYear=2018-05-15, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='THE FOREST', releaseYear=2018-04-30, genre='Horror', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='BATTLETECH', releaseYear=2018-04-24, genre='Strategy', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='FROSTPUNK', releaseYear=2018-04-24, genre='Action Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='GOD OF WAR', releaseYear=2018-04-20, genre='Action Adventure', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='FAR CRY 5', releaseYear=2018-03-27, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='Injustice 2', releaseYear=2018-03-27, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='OUTLAST 2', releaseYear=2018-03-27, genre='Survival', platform='Switch', averageRating=0.0, favoritesCounter=0}, Game{title='BATMAN: THE ENEMY WITHIN', releaseYear=2018-03-26, genre='Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='DARK SOULS REMASTERED', releaseYear=2018-03-25, genre='Action RPG', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='THE ELDER SCROLLS ONLINE: SUMMERSET', releaseYear=2018-03-21, genre='Massively Multiplayer', platform='PC', averageRating=0.0, favoritesCounter=0}]
//[Game{title='FAR: LONE SAILS', releaseYear=2018-05-17, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='DRAGON'S CROWN PRO', releaseYear=2018-05-15, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='THE FOREST', releaseYear=2018-04-30, genre='Horror', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='BATTLETECH', releaseYear=2018-04-24, genre='Strategy', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='FROSTPUNK', releaseYear=2018-04-24, genre='Action Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='GOD OF WAR', releaseYear=2018-04-20, genre='Action Adventure', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='FAR CRY 5', releaseYear=2018-03-27, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='Injustice 2', releaseYear=2018-03-27, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='OUTLAST 2', releaseYear=2018-03-27, genre='Survival', platform='Switch', averageRating=0.0, favoritesCounter=0}, Game{title='BATMAN: THE ENEMY WITHIN', releaseYear=2018-03-26, genre='Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='DARK SOULS REMASTERED', releaseYear=2018-03-25, genre='Action RPG', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='THE ELDER SCROLLS ONLINE: SUMMERSET', releaseYear=2018-03-21, genre='Massively Multiplayer', platform='PC', averageRating=0.0, favoritesCounter=0}]
//
//Process finished with exit code 0