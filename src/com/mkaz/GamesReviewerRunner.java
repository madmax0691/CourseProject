package com.mkaz;

public class GamesReviewerRunner {
    public static void main(String[] args) {
        AdminDemoManualEntering adminDemoManualEntering = new AdminDemoManualEntering();
        User madmax = new User("madmax", "Max", "Kazmyryk");
        User ahmed = new User("ahmed01", "Ahmed", "Amedov");

        FeedOfRandomGames feedOfRandomGames = new FeedOfRandomGames(adminDemoManualEntering.getGamesLibrary());

        System.out.println("Смотрим рандомную стену, страница 1");
        for (int i = 0; i < 9; i++) {
            System.out.print("#" + i);
            System.out.println(feedOfRandomGames.getFeed().get(i));
        }

        System.out.println("Список избранных игр у madmax:");
        madmax.showListOfFavorites();
        madmax.addToListOfFavorites(feedOfRandomGames.getGame(2));
        System.out.println("Список избранных игр у madmax после добавления игры:");
        madmax.showListOfFavorites();
        madmax.addToListOfFavorites(feedOfRandomGames.getGame(6));
        System.out.println("Список избранных игр у madmax после добавления игры:");
        madmax.showListOfFavorites();
        madmax.removeFromListOfFavorites(feedOfRandomGames.getGame(2));
        System.out.println("Список избранных игр у madmax после удаления игры");
        madmax.showListOfFavorites();

        System.out.println("Страница 2 рандомной стены");
        for (int i = 9; i < 12; i++) {
            System.out.print("#" + i);
            System.out.println(feedOfRandomGames.getFeed().get(i));
        }

        System.out.println("Проверяем функционал отзывов и среднего рейтинга:");
        System.out.println("Добавляем 2 отзыва от разных юзеров и выводим стену");
        feedOfRandomGames.getGame(0).addReview(new Review("Nice game", 5.0, madmax));
        feedOfRandomGames.getGame(0).addReview(new Review("Bad game", 1.0, ahmed));
        feedOfRandomGames.getGame(5).addReview(new Review("Bad game", 10.0, ahmed));

        for (int i = 0; i < 9; i++) {
            System.out.print("#" + i);
            System.out.println(feedOfRandomGames.getFeed().get(i));
        }

        System.out.println("Смотрим отзывы для игры #0");
        feedOfRandomGames.getGame(0).showReviews();

        System.out.println("Добавляем игры #3,4 в список избранных ");
        madmax.addToListOfFavorites(feedOfRandomGames.getGame(4));
        madmax.addToListOfFavorites(feedOfRandomGames.getGame(3));
        ahmed.addToListOfFavorites(feedOfRandomGames.getGame(4));

        System.out.println("Cмотрим список");
        for (int i = 0; i < 9; i++) {
            System.out.print("#" + i);
            System.out.println(feedOfRandomGames.getFeed().get(i));
        }

        FeedOfFavoritesGames feedOfFavoritesGames = new FeedOfFavoritesGames(adminDemoManualEntering.getGamesLibrary());

        System.out.println("Самая добавляемаяя игра должна быть 4 из списка случайных в списке самых добавляемых:");
        for (int i = 0; i < 9; i++) {
            System.out.print("#" + i);
            System.out.println(feedOfFavoritesGames.getFeed().get(i));
        }

        FeedOfTopGames feedOfTopGames = new FeedOfTopGames(adminDemoManualEntering.getGamesLibrary());

        System.out.println("Самая топовая игра должна быть 5 из списка рандомных");
        for (int i = 0; i < 9; i++) {
            System.out.print("#" + i);
            System.out.println(feedOfTopGames.getFeed().get(i));
        }

    }
}
//Test
//Смотрим рандомную стену, страница 1
//#0Game{title='GOD OF WAR', releaseYear=2018-04-20, genre='Action Adventure', platform='PS4', averageRating=0.0, favoritesCounter=0}
//#1Game{title='OUTLAST 2', releaseYear=2018-03-27, genre='Survival', platform='Switch', averageRating=0.0, favoritesCounter=0}
//#2Game{title='DRAGON'S CROWN PRO', releaseYear=2018-05-15, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}
//#3Game{title='THE FOREST', releaseYear=2018-04-30, genre='Horror', platform='PC', averageRating=0.0, favoritesCounter=0}
//#4Game{title='BATMAN: THE ENEMY WITHIN', releaseYear=2018-03-26, genre='Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}
//#5Game{title='FAR: LONE SAILS', releaseYear=2018-05-17, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}
//#6Game{title='Injustice 2', releaseYear=2018-03-27, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}
//#7Game{title='FAR CRY 5', releaseYear=2018-03-27, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}
//#8Game{title='FROSTPUNK', releaseYear=2018-04-24, genre='Action Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}
//Список избранных игр у madmax:
//[]
//Список избранных игр у madmax после добавления игры:
//[Game{title='DRAGON'S CROWN PRO', releaseYear=2018-05-15, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=1}]
//Список избранных игр у madmax после добавления игры:
//[Game{title='DRAGON'S CROWN PRO', releaseYear=2018-05-15, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=1}, Game{title='Injustice 2', releaseYear=2018-03-27, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=1}]
//Список избранных игр у madmax после удаления игры
//[Game{title='Injustice 2', releaseYear=2018-03-27, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=1}]
//Страница 2 рандомной стены
//#9Game{title='BATTLETECH', releaseYear=2018-04-24, genre='Strategy', platform='PC', averageRating=0.0, favoritesCounter=0}
//#10Game{title='DARK SOULS REMASTERED', releaseYear=2018-03-25, genre='Action RPG', platform='PS4', averageRating=0.0, favoritesCounter=0}
//#11Game{title='THE ELDER SCROLLS ONLINE: SUMMERSET', releaseYear=2018-03-21, genre='Massively Multiplayer', platform='PC', averageRating=0.0, favoritesCounter=0}
//Проверяем функционал отзывов и среднего рейтинга:
//Добавляем 2 отзыва от разных юзеров и выводим стену
//#0Game{title='GOD OF WAR', releaseYear=2018-04-20, genre='Action Adventure', platform='PS4', averageRating=3.0, favoritesCounter=0}
//#1Game{title='OUTLAST 2', releaseYear=2018-03-27, genre='Survival', platform='Switch', averageRating=0.0, favoritesCounter=0}
//#2Game{title='DRAGON'S CROWN PRO', releaseYear=2018-05-15, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}
//#3Game{title='THE FOREST', releaseYear=2018-04-30, genre='Horror', platform='PC', averageRating=0.0, favoritesCounter=0}
//#4Game{title='BATMAN: THE ENEMY WITHIN', releaseYear=2018-03-26, genre='Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}
//#5Game{title='FAR: LONE SAILS', releaseYear=2018-05-17, genre='Action', platform='PC', averageRating=10.0, favoritesCounter=0}
//#6Game{title='Injustice 2', releaseYear=2018-03-27, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=1}
//#7Game{title='FAR CRY 5', releaseYear=2018-03-27, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}
//#8Game{title='FROSTPUNK', releaseYear=2018-04-24, genre='Action Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}
//Смотрим отзывы для игры #0
//Review{review='Nice game', rating=5.0, user=User{nickName='madmax', name='Max', surname='Kazmyryk'}}
//Review{review='Bad game', rating=1.0, user=User{nickName='ahmed01', name='Ahmed', surname='Amedov'}}
//Добавляем игры #3,4 в список избранных
//Cмотрим список
//#0Game{title='GOD OF WAR', releaseYear=2018-04-20, genre='Action Adventure', platform='PS4', averageRating=3.0, favoritesCounter=0}
//#1Game{title='OUTLAST 2', releaseYear=2018-03-27, genre='Survival', platform='Switch', averageRating=0.0, favoritesCounter=0}
//#2Game{title='DRAGON'S CROWN PRO', releaseYear=2018-05-15, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}
//#3Game{title='THE FOREST', releaseYear=2018-04-30, genre='Horror', platform='PC', averageRating=0.0, favoritesCounter=1}
//#4Game{title='BATMAN: THE ENEMY WITHIN', releaseYear=2018-03-26, genre='Adventure', platform='PC', averageRating=0.0, favoritesCounter=2}
//#5Game{title='FAR: LONE SAILS', releaseYear=2018-05-17, genre='Action', platform='PC', averageRating=10.0, favoritesCounter=0}
//#6Game{title='Injustice 2', releaseYear=2018-03-27, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=1}
//#7Game{title='FAR CRY 5', releaseYear=2018-03-27, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}
//#8Game{title='FROSTPUNK', releaseYear=2018-04-24, genre='Action Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}
//Самая добавляемаяя игра должна быть 4 из списка случайных в списке самых добавляемых:
//#0Game{title='BATMAN: THE ENEMY WITHIN', releaseYear=2018-03-26, genre='Adventure', platform='PC', averageRating=0.0, favoritesCounter=2}
//#1Game{title='THE FOREST', releaseYear=2018-04-30, genre='Horror', platform='PC', averageRating=0.0, favoritesCounter=1}
//#2Game{title='Injustice 2', releaseYear=2018-03-27, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=1}
//#3Game{title='BATTLETECH', releaseYear=2018-04-24, genre='Strategy', platform='PC', averageRating=0.0, favoritesCounter=0}
//#4Game{title='OUTLAST 2', releaseYear=2018-03-27, genre='Survival', platform='Switch', averageRating=0.0, favoritesCounter=0}
//#5Game{title='FAR: LONE SAILS', releaseYear=2018-05-17, genre='Action', platform='PC', averageRating=10.0, favoritesCounter=0}
//#6Game{title='DRAGON'S CROWN PRO', releaseYear=2018-05-15, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}
//#7Game{title='FAR CRY 5', releaseYear=2018-03-27, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}
//#8Game{title='THE ELDER SCROLLS ONLINE: SUMMERSET', releaseYear=2018-03-21, genre='Massively Multiplayer', platform='PC', averageRating=0.0, favoritesCounter=0}
//Самая топовая игра должна быть 5 из списка рандомных
//#0Game{title='FAR: LONE SAILS', releaseYear=2018-05-17, genre='Action', platform='PC', averageRating=10.0, favoritesCounter=0}
//#1Game{title='GOD OF WAR', releaseYear=2018-04-20, genre='Action Adventure', platform='PS4', averageRating=3.0, favoritesCounter=0}
//#2Game{title='BATTLETECH', releaseYear=2018-04-24, genre='Strategy', platform='PC', averageRating=0.0, favoritesCounter=0}
//#3Game{title='OUTLAST 2', releaseYear=2018-03-27, genre='Survival', platform='Switch', averageRating=0.0, favoritesCounter=0}
//#4Game{title='DRAGON'S CROWN PRO', releaseYear=2018-05-15, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}
//#5Game{title='FAR CRY 5', releaseYear=2018-03-27, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}
//#6Game{title='THE FOREST', releaseYear=2018-04-30, genre='Horror', platform='PC', averageRating=0.0, favoritesCounter=1}
//#7Game{title='THE ELDER SCROLLS ONLINE: SUMMERSET', releaseYear=2018-03-21, genre='Massively Multiplayer', platform='PC', averageRating=0.0, favoritesCounter=0}
//#8Game{title='FROSTPUNK', releaseYear=2018-04-24, genre='Action Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}
//
//Process finished with exit code 0

