package CourseProjectOne;

import java.util.ArrayList;

public class User {
    private final String nickName;
    private final String name;
    private final String surname;
    private final ArrayList<Game> favoriteGames = new ArrayList<>();

    public User(String nickName, String name, String surname) {
        this.nickName = nickName;
        this.name = name;
        this.surname = surname;
    }

    public void showListOfFavorites(){
        System.out.println(favoriteGames);
    }
    public void addToListOfFavorites(Game game){
        favoriteGames.add(game);
        game.setFavoritesCounter(game.getFavoritesCounter()+1);
    }
    public void removeFromListOfFavorites(Game game){
        for (Game tempGame : favoriteGames) {
            if (tempGame.equals(game)){
                favoriteGames.remove(game);
            } else {
                throw new IllegalArgumentException("Sorry, but you do not have this game in your favorites");
            }
        }
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
