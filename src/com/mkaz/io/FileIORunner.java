package com.mkaz.io;

import com.mkaz.io.fileio.Formatter;
import com.mkaz.io.fileio.GamesFileIn;
import com.mkaz.io.fileio.TextFileIO;

public class FileIORunner {

    public static void main(String[] args) {
        String informationFromFile = TextFileIO.read("files/games.csv", ",");
        System.out.println(informationFromFile);
        Formatter formatter = new Formatter("csv", informationFromFile);
        System.out.println(formatter.getFormattedInfo());

        GamesFileIn gamesFileIn = new GamesFileIn(formatter.getFormattedInfo());
        gamesFileIn.addAllGames();
        System.out.println(gamesFileIn.getGamesLibrary().getGames());
//

//        //Check users fileINPUT
//        UsersFileIn usersFileIn = new UsersFileIn("files/usersin.csv", ",",
//                4, gamesFileIn.getGamesLibrary());
//
//        //check lists
//        System.out.println();
//        usersFileIn.getUsers().get(0).showListOfFavorites();
//        usersFileIn.getUsers().get(1).showListOfFavorites();
//
//        //check reviews fileINPUT
//        ReviewsFileIn reviewsFileIn = new ReviewsFileIn("files/reviewsin.csv", ",",
//                3, usersFileIn.getUsers());
//        reviewsFileIn.addReviews(gamesFileIn.getGamesLibrary().getGames().get(3));
//        FeedOfTopGames feedOfTopGames = new FeedOfTopGames(gamesFileIn.getGamesLibrary());
//
//        //Show TOPfeed, "BATMAN: THE ENEMY WITHIN" must be on the top
//        System.out.println();
//        for (int i = 0; i < 9; i++) {
//            System.out.print("#" + i);
//            System.out.println(feedOfTopGames.getFeed().get(i));
//        }
//
//        //check Games fileOUTPUT
//        new GamesFileOut("files/gamesout.tsv", gamesFileIn.getGamesLibrary());
//        System.out.println("Done");
//        new UsersFileOut("files/usersout.tsv", usersFileIn.getUsers());
//        System.out.println("Done");
//        new ReviewsFileOut("files/reviewsout.tsv", gamesFileIn.getGamesLibrary().getGames().
//                get(3).getReviews());
//        System.out.println("Done");
    }
}