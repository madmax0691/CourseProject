package CourseProjectOne;

public class GamesReviewerRunner {
    public static void main(String[] args) {
        AdminDemo adminDemo = new AdminDemo();
        User madmax = new User("madmax", "Max", "Kazmyryk");
        User ahmed = new User("ahmed01", "Ahmed", "Amedov");

        FeedOfRandomGames feedOfRandomGames = new FeedOfRandomGames(adminDemo.getGamesLibrary());
        System.out.println("Смотрим рандомную стену, страница 1");
        feedOfRandomGames.showFeed(1);
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
        feedOfRandomGames.showFeed(2);
        System.out.println("Проверяем функционал отзывов и среднего рейтинга:");
        System.out.println("Добавляем 2 отзыва от разных юзеров и выводим стену");
        feedOfRandomGames.getGame(0).addReview(new Review("Nice game", 5.0, madmax));
        feedOfRandomGames.getGame(0).addReview(new Review("Bad game", 1.0, ahmed));
        feedOfRandomGames.getGame(5).addReview(new Review("Bad game", 10.0, ahmed));
        feedOfRandomGames.showFeed(1);
        feedOfRandomGames.getGame(0).showReviews();
        madmax.addToListOfFavorites(feedOfRandomGames.getGame(4));
        madmax.addToListOfFavorites(feedOfRandomGames.getGame(3));
        ahmed.addToListOfFavorites(feedOfRandomGames.getGame(4));
        feedOfRandomGames.showFeed(1);
        System.out.println("Самая добавляемаяя игра должна быть 4 из списка случайных в списке самых добавляемых:");
        FeedOfFavoritesGames feedOfFavoritesGames = new FeedOfFavoritesGames(adminDemo.getGamesLibrary());
        feedOfFavoritesGames.showFeed(1);
        System.out.println("Самая топовая игра должна быть 5 из списка рандомных");
        FeedOfTopGames feedOfTopGames = new FeedOfTopGames(adminDemo.getGamesLibrary());
        feedOfTopGames.showFeed(1);

    }
}
//Test
//"C:\Program Files\Java\jdk1.8.0_171\bin\java" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2017.2\lib\idea_rt.jar=54123:C:\Program Files\JetBrains\IntelliJ IDEA 2017.2\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_171\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_171\jre\lib\rt.jar;C:\Users\mid\IdeaProjects\CourseProject\out\production\CourseProject" CourseProjectOne.GamesReviewerRunner
//        Смотрим рандомную стену, страница 1
//        #0: Game{title='Injustice 2', releaseYear=2018-03-27, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}
//        #1: Game{title='DARK SOULS REMASTERED', releaseYear=2018-03-25, genre='Action RPG', platform='PS4', averageRating=0.0, favoritesCounter=0}
//        #2: Game{title='FROSTPUNK', releaseYear=2018-04-24, genre='Action Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}
//        #3: Game{title='FAR: LONE SAILS', releaseYear=2018-05-17, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}
//        #4: Game{title='FAR CRY 5', releaseYear=2018-03-27, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}
//        #5: Game{title='DRAGON'S CROWN PRO', releaseYear=2018-05-15, genre='Action', platform='PS4', averageRating=0.0, favoritesCounter=0}
//        #6: Game{title='BATMAN: THE ENEMY WITHIN', releaseYear=2018-03-26, genre='Adventure', platform='PC', averageRating=0.0, favoritesCounter=0}
//        #7: Game{title='GOD OF WAR', releaseYear=2018-04-20, genre='Action Adventure', platform='PS4', averageRating=0.0, favoritesCounter=0}
//        #8: Game{title='THE FOREST', releaseYear=2018-04-30, genre='Horror', platform='PC', averageRating=0.0, favoritesCounter=0}
//        Список избранных игр у madmax:
//        []
//        Список избранных игр у madmax после добавления игры:
//        [Game{title='FROSTPUNK', releaseYear=2018-04-24, genre='Action Adventure', platform='PC', averageRating=0.0, favoritesCounter=1}]
//        Список избранных игр у madmax после добавления игры:
//        [Game{title='FROSTPUNK', releaseYear=2018-04-24, genre='Action Adventure', platform='PC', averageRating=0.0, favoritesCounter=1}, Game{title='BATMAN: THE ENEMY WITHIN', releaseYear=2018-03-26, genre='Adventure', platform='PC', averageRating=0.0, favoritesCounter=1}]
//        Список избранных игр у madmax после удаления игры
//        [Game{title='BATMAN: THE ENEMY WITHIN', releaseYear=2018-03-26, genre='Adventure', platform='PC', averageRating=0.0, favoritesCounter=1}]
//        Страница 2 рандомной стены
//        #9: Game{title='OUTLAST 2', releaseYear=2018-03-27, genre='Survival', platform='Switch', averageRating=0.0, favoritesCounter=0}
//        #10: Game{title='THE ELDER SCROLLS ONLINE: SUMMERSET', releaseYear=2018-03-21, genre='Massively Multiplayer', platform='PC', averageRating=0.0, favoritesCounter=0}
//        #11: Game{title='BATTLETECH', releaseYear=2018-04-24, genre='Strategy', platform='PC', averageRating=0.0, favoritesCounter=0}
//        Проверяем функционал отзывов и среднего рейтинга:
//        Добавляем 2 отзыва от разных юзеров и выводим стену
//        #0: Game{title='Injustice 2', releaseYear=2018-03-27, genre='Action', platform='PS4', averageRating=3.0, favoritesCounter=0}
//        #1: Game{title='DARK SOULS REMASTERED', releaseYear=2018-03-25, genre='Action RPG', platform='PS4', averageRating=0.0, favoritesCounter=0}
//        #2: Game{title='FROSTPUNK', releaseYear=2018-04-24, genre='Action Adventure', platform='PC', averageRating=0.0, favoritesCounter=1}
//        #3: Game{title='FAR: LONE SAILS', releaseYear=2018-05-17, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}
//        #4: Game{title='FAR CRY 5', releaseYear=2018-03-27, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=0}
//        #5: Game{title='DRAGON'S CROWN PRO', releaseYear=2018-05-15, genre='Action', platform='PS4', averageRating=10.0, favoritesCounter=0}
//        #6: Game{title='BATMAN: THE ENEMY WITHIN', releaseYear=2018-03-26, genre='Adventure', platform='PC', averageRating=0.0, favoritesCounter=1}
//        #7: Game{title='GOD OF WAR', releaseYear=2018-04-20, genre='Action Adventure', platform='PS4', averageRating=0.0, favoritesCounter=0}
//        #8: Game{title='THE FOREST', releaseYear=2018-04-30, genre='Horror', platform='PC', averageRating=0.0, favoritesCounter=0}
//        Review{review='Nice game', rating=5.0, user=User{nickName='madmax', name='Max', surname='Kazmyryk'}}
//        Review{review='Bad game', rating=1.0, user=User{nickName='ahmed01', name='Ahmed', surname='Amedov'}}
//        #0: Game{title='Injustice 2', releaseYear=2018-03-27, genre='Action', platform='PS4', averageRating=3.0, favoritesCounter=0}
//        #1: Game{title='DARK SOULS REMASTERED', releaseYear=2018-03-25, genre='Action RPG', platform='PS4', averageRating=0.0, favoritesCounter=0}
//        #2: Game{title='FROSTPUNK', releaseYear=2018-04-24, genre='Action Adventure', platform='PC', averageRating=0.0, favoritesCounter=1}
//        #3: Game{title='FAR: LONE SAILS', releaseYear=2018-05-17, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=1}
//        #4: Game{title='FAR CRY 5', releaseYear=2018-03-27, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=2}
//        #5: Game{title='DRAGON'S CROWN PRO', releaseYear=2018-05-15, genre='Action', platform='PS4', averageRating=10.0, favoritesCounter=0}
//        #6: Game{title='BATMAN: THE ENEMY WITHIN', releaseYear=2018-03-26, genre='Adventure', platform='PC', averageRating=0.0, favoritesCounter=1}
//        #7: Game{title='GOD OF WAR', releaseYear=2018-04-20, genre='Action Adventure', platform='PS4', averageRating=0.0, favoritesCounter=0}
//        #8: Game{title='THE FOREST', releaseYear=2018-04-30, genre='Horror', platform='PC', averageRating=0.0, favoritesCounter=0}
//        Самая добавляемаяя игра должна быть 4 из списка случайных в списке самых добавляемых:
//        #0: Game{title='FAR CRY 5', releaseYear=2018-03-27, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=2}
//        #1: Game{title='BATMAN: THE ENEMY WITHIN', releaseYear=2018-03-26, genre='Adventure', platform='PC', averageRating=0.0, favoritesCounter=1}
//        #2: Game{title='FAR: LONE SAILS', releaseYear=2018-05-17, genre='Action', platform='PC', averageRating=0.0, favoritesCounter=1}
//        #3: Game{title='FROSTPUNK', releaseYear=2018-04-24, genre='Action Adventure', platform='PC', averageRating=0.0, favoritesCounter=1}
//        #4: Game{title='BATTLETECH', releaseYear=2018-04-24, genre='Strategy', platform='PC', averageRating=0.0, favoritesCounter=0}
//        #5: Game{title='THE ELDER SCROLLS ONLINE: SUMMERSET', releaseYear=2018-03-21, genre='Massively Multiplayer', platform='PC', averageRating=0.0, favoritesCounter=0}
//        #6: Game{title='OUTLAST 2', releaseYear=2018-03-27, genre='Survival', platform='Switch', averageRating=0.0, favoritesCounter=0}
//        #7: Game{title='THE FOREST', releaseYear=2018-04-30, genre='Horror', platform='PC', averageRating=0.0, favoritesCounter=0}
//        #8: Game{title='GOD OF WAR', releaseYear=2018-04-20, genre='Action Adventure', platform='PS4', averageRating=0.0, favoritesCounter=0}
//        Самая топовая игра должна быть 5 из списка рандомных
//        #0: Game{title='DRAGON'S CROWN PRO', releaseYear=2018-05-15, genre='Action', platform='PS4', averageRating=10.0, favoritesCounter=0}
//        #1: Game{title='Injustice 2', releaseYear=2018-03-27, genre='Action', platform='PS4', averageRating=3.0, favoritesCounter=0}
//        #2: Game{title='DARK SOULS REMASTERED', releaseYear=2018-03-25, genre='Action RPG', platform='PS4', averageRating=0.0, favoritesCounter=0}
//        #3: Game{title='GOD OF WAR', releaseYear=2018-04-20, genre='Action Adventure', platform='PS4', averageRating=0.0, favoritesCounter=0}
//        #4: Game{title='THE FOREST', releaseYear=2018-04-30, genre='Horror', platform='PC', averageRating=0.0, favoritesCounter=0}
//        #5: Game{title='OUTLAST 2', releaseYear=2018-03-27, genre='Survival', platform='Switch', averageRating=0.0, favoritesCounter=0}
//        #6: Game{title='THE ELDER SCROLLS ONLINE: SUMMERSET', releaseYear=2018-03-21, genre='Massively Multiplayer', platform='PC', averageRating=0.0, favoritesCounter=0}
//        #7: Game{title='BATTLETECH', releaseYear=2018-04-24, genre='Strategy', platform='PC', averageRating=0.0, favoritesCounter=0}
//        #8: Game{title='FROSTPUNK', releaseYear=2018-04-24, genre='Action Adventure', platform='PC', averageRating=0.0, favoritesCounter=1}
//
//        Process finished with exit code 0


