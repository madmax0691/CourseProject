package CourseProjectOne.IOModule.FileIO;

import CourseProjectOne.User;

import java.util.Arrays;
import java.util.List;

public class UsersFileOut {
    private final StringBuilder stringBuilder = new StringBuilder();

    public UsersFileOut(String fileName, List<User> users) {
        addFirstLine();
        TextFileIO.write(fileName, initialize(users));
    }

    private void addFirstLine() {
        stringBuilder.append("\"" + "NickName:" + "\"" + "\t" + "\"" + "Name:" + "\"" + "\t" + "\"" + "SurName:"
                + "\"" + "\t" + "\"" + "List of favorite games:" + "\" " + "\n");
    }

    private List<String> initialize(List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            stringBuilder.append("\"");
            stringBuilder.append(users.get(i).getNickName());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(users.get(i).getName());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(users.get(i).getSurname());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(users.get(i).getListOfFavorites());
            stringBuilder.append("\"");
            stringBuilder.append("\n");
        }
        List<String> outInfo = Arrays.asList(stringBuilder.toString().split("\n"));
        return outInfo;
    }
}
