package com.mkaz.io;

import com.mkaz.FeedOfTopGames;
import com.mkaz.io.fileio.*;

public class FileIORunner {

    public static void main(String[] args) {
        String gamesInfo = TextFileIO.read("files/games.csv", ",");
        Formatter gamesFormatter = new Formatter("csv", gamesInfo);
        GamesFileIn gamesFileIn = new GamesFileIn(gamesFormatter.getFormattedInfo());
        gamesFileIn.addAllGames();

        System.out.println(gamesFileIn.getGamesLibrary().getGames());

        String usersInfo = TextFileIO.read("files/users.csv", ",");
        Formatter usersFormatter = new Formatter("csv", usersInfo);
        UsersFileIn usersFileIn = new UsersFileIn(usersFormatter.getFormattedInfo());
        usersFileIn.createUsers();
        usersFileIn.initialize(gamesFileIn.getGamesLibrary());

        usersFileIn.getUsers().get(0).showListOfFavorites();
        usersFileIn.getUsers().get(1).showListOfFavorites();

        String reviewsInfo = TextFileIO.read("files/reviews.csv", ",");
        Formatter reviewsFormatter = new Formatter("csv", reviewsInfo);
        ReviewsFileIn reviewsFileIn = new ReviewsFileIn(reviewsFormatter.getFormattedInfo());
        reviewsFileIn.initialize(usersFileIn.getUsers());
        reviewsFileIn.addReviews(gamesFileIn.getGamesLibrary().getGames().get(3));

        FeedOfTopGames feedOfTopGames = new FeedOfTopGames(gamesFileIn.getGamesLibrary());
        System.out.println();
        for (int i = 0; i < 9; i++) {
            System.out.print("#" + i);
            System.out.println(feedOfTopGames.getFeed().get(i));
        }

        TextFileIO.createFile("files/games.tsv");
        GamesFileOut gamesFileOut = new GamesFileOut(gamesFileIn.getGamesLibrary());
        gamesFileOut.write("files/games.tsv");

        TextFileIO.createFile("files/users.tsv");
        UsersFileOut usersFileOut = new UsersFileOut(usersFileIn.getUsers());
        usersFileOut.write("files/users.tsv");

        TextFileIO.createFile("files/reviews.tsv");
        ReviewsFileOut reviewsFileOut = new ReviewsFileOut(gamesFileIn.getGamesLibrary().getGames().get(3).getReviews());
        reviewsFileOut.write("files/reviews.tsv");
    }
}
//Test
//[Game{title='GOD OF WAR', releaseYear=2018-04-20, genre='Action Adventure', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='Injustice 2', releaseYear=2018-03-27, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='DARK SOULS REMASTERED', releaseYear=2018-03-25, genre='Action RPG', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='BATMAN: THE ENEMY WITHIN', releaseYear=2018-03-26, genre='Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='FROSTPUNK', releaseYear=2018-04-24, genre='Action Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='THE ELDER SCROLLS ONLINE: SUMMERSET', releaseYear=2018-03-21, genre='Massively Multiplayer', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='THE FOREST', releaseYear=2018-04-30, genre='Horror', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='FAR CRY 5', releaseYear=2018-03-27, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='DRAGON'S CROWN PRO', releaseYear=2018-05-15, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='FAR: LONE SAILS', releaseYear=2018-05-17, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='OUTLAST 2', releaseYear=2018-03-27, genre='Survival', platform='Switch', averageRating=0.0, favoritesCounter=0}, Game{title='BATTLETECH', releaseYear=2018-04-24, genre='Strategy', platform='PC', averageRating=0.0, favoritesCounter=0}]
//[Game{title='GOD OF WAR', releaseYear=2018-04-20, genre='Action Adventure', platform='PS4', averageRating=0.0, favoritesCounter=1}, Game{title='DARK SOULS REMASTERED', releaseYear=2018-03-25, genre='Action RPG', platform='PS4', averageRating=0.0, favoritesCounter=1}]
//[Game{title='THE ELDER SCROLLS ONLINE: SUMMERSET', releaseYear=2018-03-21, genre='Massively Multiplayer', platform='PC', averageRating=0.0, favoritesCounter=1}]
//
//#0Game{title='BATMAN: THE ENEMY WITHIN', releaseYear=2018-03-26, genre='Adventure', platform='PC', averageRating=3.0, favoritesCounter=0}
//#1Game{title='BATTLETECH', releaseYear=2018-04-24, genre='Strategy', platform='PC', averageRating=0.0, favoritesCounter=0}
//#2Game{title='OUTLAST 2', releaseYear=2018-03-27, genre='Survival', platform='Switch', averageRating=0.0, favoritesCounter=0}
//#3Game{title='FAR: LONE SAILS', releaseYear=2018-05-17, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}
//#4Game{title='DRAGON'S CROWN PRO', releaseYear=2018-05-15, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}
//#5Game{title='FAR CRY 5', releaseYear=2018-03-27, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}
//#6Game{title='THE FOREST', releaseYear=2018-04-30, genre='Horror', platform='PC', averageRating=0.0, favoritesCounter=0}
//#7Game{title='THE ELDER SCROLLS ONLINE: SUMMERSET', releaseYear=2018-03-21, genre='Massively Multiplayer', platform='PC', averageRating=0.0, favoritesCounter=1}
//#8Game{title='FROSTPUNK', releaseYear=2018-04-24, genre='Action Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}
//File: files/games.tsv has created!
//File: files/users.tsv has created!
//File: files/reviews.tsv has created!
//
//Process finished with exit code 0