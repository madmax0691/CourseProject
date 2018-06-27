package CourseProjectOne.IOModule.FileIO;

import CourseProjectOne.GamesLibrary;
import CourseProjectOne.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersFileIn {
    private final List<User> users = new ArrayList<>();

    public UsersFileIn(String fileName, String splitter, int numberOfColumns, GamesLibrary gamesLibrary) {
        List<String> usersInput = TextFileIO.read(fileName, splitter);
        remove(usersInput, numberOfColumns);
        createUsers(usersInput, numberOfColumns);
        initialize(usersInput, numberOfColumns, gamesLibrary);
    }

    private void remove(List<String> list, int numberOfColumns) {
        for (int i = 0; i < numberOfColumns; i++) {
            list.remove(0);
        }
    }

    private void createUsers(List<String> list, int numberOfColumns) {
        for (int i = 0; i < list.size() / numberOfColumns; i++) {
            users.add(new User(list.get(i * numberOfColumns), list.get(1 + i * numberOfColumns),
                    list.get(2 + i * numberOfColumns)));
        }
    }

    private void initialize(List<String> list, int numberOfColumns, GamesLibrary gamesLibrary) {
        int counter = 0;
        for (User user : users) {
            List<String> games = Arrays.asList(list.get(3 + counter * numberOfColumns).split(","));
            counter++;
            for (String name : games) {
                user.addToListOfFavorites(gamesLibrary.getGameByName(name));//temporal!
            }
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
