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

//        new GamesFileOut("files/gamesout.tsv", gamesFileIn.getGamesLibrary());
//        System.out.println("Done");
//        new UsersFileOut("files/usersout.tsv", usersFileIn.getUsers());
//        System.out.println("Done");
//        new ReviewsFileOut("files/reviewsout.tsv", gamesFileIn.getGamesLibrary().getGames().
//                get(3).getReviews());
//        System.out.println("Done");
    }
}