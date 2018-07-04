package com.mkaz.io.fileio;

import com.mkaz.User;

import java.util.ArrayList;
import java.util.List;

public class UsersFileOut {
    private final List<User> users;
    private final List<String> usersInfo = new ArrayList<>();

    public UsersFileOut(List<User> users) {
        this.users = users;
        initialize();
    }

    private void addFirstLine() {
        usersInfo.add("\"" + "NickName:" + "\"" + "\t" + "\"" + "Name:" + "\"" + "\t" + "\"" + "SurName:"
                + "\"" + "\t" + "\"" + "List of favorite games:" + "\"");
    }

    private void initialize() {
        addFirstLine();
        StringBuilder stringBuilder;
        for (User user : users) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("\"");
            stringBuilder.append(user.getNickName());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(user.getName());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(user.getSurname());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(user.getListOfFavorites());
            stringBuilder.append("\"");
            usersInfo.add(stringBuilder.toString());
        }
    }

    public void write(String fileName) {
        TextFileIO.write(fileName, usersInfo);
    }
}
