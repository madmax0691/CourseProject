package CourseProjectOne.IOModule.FileIO;

import CourseProjectOne.GamesLibrary;

import java.util.Arrays;
import java.util.List;

public class GamesFileOut {
    private final StringBuilder stringBuilder = new StringBuilder();

    public GamesFileOut(String fileName, GamesLibrary gamesLibrary) {
        addFirstLine();
        TextFileIO.write(fileName, initialize(gamesLibrary));
    }

    private void addFirstLine() {
        stringBuilder.append("\"" + "Title:" + "\"" + "\t" + "\"" + "Description:" + "\"" + "\t" + "\"" + "ReleaseYear:"
                + "\"" + "\t" + "\"" + "Genre:" + "\"" + "\t" + "\"" + "Platform:" + "\"" + "\n");
    }

    private List<String> initialize(GamesLibrary gamesLibrary) {
        for (int i = 0; i < gamesLibrary.getGames().size(); i++) {
            stringBuilder.append("\"");
            stringBuilder.append(gamesLibrary.getGames().get(i).getTitle());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(gamesLibrary.getGames().get(i).getDescription());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(gamesLibrary.getGames().get(i).getReleaseYear());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(gamesLibrary.getGames().get(i).getGenre());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(gamesLibrary.getGames().get(i).getPlatform());
            stringBuilder.append("\"");
            stringBuilder.append("\n");
        }
        List<String> outInfo = Arrays.asList(stringBuilder.toString().split("\n"));
        return outInfo;
    }
}
