package CourseProjectOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private final String nickName;
    private final String name;
    private final String surname;
    private final List<Game> favoriteGames = new ArrayList<>();

    public User(String nickName, String name, String surname) {
        this.nickName = nickName;
        this.name = name;
        this.surname = surname;
    }

    public void showListOfFavorites() {
        System.out.println(favoriteGames);
    }

    public void addToListOfFavorites(Game game) {
        favoriteGames.add(game);
        game.setFavoritesCounter(game.getFavoritesCounter() + 1);
    }

    public void removeFromListOfFavorites(Game game) {
        for (Game tempGame : favoriteGames) {
            if (tempGame.equals(game)) {
                favoriteGames.remove(game);
                game.setFavoritesCounter(game.getFavoritesCounter() - 1);
            } else {
                throw new IllegalArgumentException("Sorry, but you do not have this game in your favorites");
            }
        }
    }

    public String getNickName() {
        return nickName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getListOfFavorites(){
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (Game game : favoriteGames) {
            if (game.equals(favoriteGames.get(favoriteGames.size()-1))){
                stringBuilder.append(game.getTitle());
            } else {
                stringBuilder.append(game.getTitle()+",");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "User{" +
                "nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
