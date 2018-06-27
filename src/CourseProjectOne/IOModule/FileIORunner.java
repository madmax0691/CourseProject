package CourseProjectOne.IOModule;

import CourseProjectOne.FeedOfTopGames;
import CourseProjectOne.IOModule.FileIO.*;

public class FileIORunner {

    public static void main(String[] args) {
        //Check games fileINPUT
        GamesFileIn gamesFileIn = new GamesFileIn("Files/GamesIn.csv", ",",
                5);

        System.out.println(gamesFileIn.getGamesLibrary().getGames());//check games initialization from file

        //Check users fileINPUT
        UsersFileIn usersFileIn = new UsersFileIn("Files/UsersIn.csv", ",",
                4, gamesFileIn.getGamesLibrary());

        //check lists
        System.out.println();
        usersFileIn.getUsers().get(0).showListOfFavorites();
        usersFileIn.getUsers().get(1).showListOfFavorites();

        //check reviews fileINPUT
        ReviewsFileIn reviewsFileIn = new ReviewsFileIn("Files/ReviewsIn.csv", ",",
                3, usersFileIn.getUsers());
        reviewsFileIn.addReviews(gamesFileIn.getGamesLibrary().getGames().get(3));
        FeedOfTopGames feedOfTopGames = new FeedOfTopGames(gamesFileIn.getGamesLibrary());

        //Show TOPfeed, "BATMAN: THE ENEMY WITHIN" must be on the top
        System.out.println();
        for (int i = 0; i < 9; i++) {
            System.out.print("#" + i);
            System.out.println(feedOfTopGames.getFeed().get(i));
        }

        //check Games fileOUTPUT
        new GamesFileOut("Files/GamesOut.tsv",gamesFileIn.getGamesLibrary());
        System.out.println("Done");
        new UsersFileOut("Files/UsersOut.tsv",usersFileIn.getUsers());
        System.out.println("Done");
        new ReviewsFileOut("Files/ReviewsOut.tsv",gamesFileIn.getGamesLibrary().getGames().
                get(3).getReviews());
        System.out.println("Done");
    }
}
//Test
//[Game{title='GOD OF WAR', releaseYear=2018-04-20, genre='Action Adventure', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='Injustice 2', releaseYear=2018-03-27, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='DARK SOULS REMASTERED', releaseYear=2018-03-25, genre='Action RPG', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='BATMAN: THE ENEMY WITHIN', releaseYear=2018-03-26, genre='Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='FROSTPUNK', releaseYear=2018-04-24, genre='Action Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='THE ELDER SCROLLS ONLINE: SUMMERSET', releaseYear=2018-03-21, genre='Massively Multiplayer', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='THE FOREST', releaseYear=2018-04-30, genre='Horror', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='FAR CRY 5', releaseYear=2018-03-27, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='DRAGON'S CROWN PRO', releaseYear=2018-05-15, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}, Game{title='FAR: LONE SAILS', releaseYear=2018-05-17, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}, Game{title='OUTLAST 2', releaseYear=2018-03-27, genre='Survival', platform='Switch', averageRating=0.0, favoritesCounter=0}, Game{title='BATTLETECH', releaseYear=2018-04-24, genre='Strategy', platform='PC', averageRating=0.0, favoritesCounter=0}]
//
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
//Done
//Done
//Done
//
//Process finished with exit code 0