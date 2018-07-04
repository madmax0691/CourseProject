package com.mkaz.io.fileio;

import com.mkaz.GamesLibrary;
import com.mkaz.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersFileIn {
    private static final int NUMBER_OF_COLUMNS = 4;
    private final List<User> users = new ArrayList<>();
    private final List<String> userInfo;

    public UsersFileIn(List<String> userInfo) {
        this.userInfo = userInfo;
        remove();
    }

    private void remove() {
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            userInfo.remove(0);
        }
    }

    public void createUsers() {
        for (int i = 0; i < userInfo.size() / NUMBER_OF_COLUMNS; i++) {
            users.add(new User(userInfo.get(i * NUMBER_OF_COLUMNS), userInfo.get(1 + i * NUMBER_OF_COLUMNS),
                    userInfo.get(2 + i * NUMBER_OF_COLUMNS)));
        }
    }

    public void initialize(GamesLibrary gamesLibrary) {
        int counter = 0;
        for (User user : users) {
            List<String> games = Arrays.asList(userInfo.get(3 + counter * NUMBER_OF_COLUMNS).split(","));
            counter++;
            for (String name : games) {
                user.addToListOfFavorites(gamesLibrary.getGameByName(name));//TODO 1
            }
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
