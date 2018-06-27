package CourseProjectOne.IOModule.FileIO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextFileIO {

    public static List<String> read(String fileName, String splitter) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(
                    new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    stringBuilder.append(s);
                    stringBuilder.append(splitter);
                }
            } finally {
                bufferedReader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(Arrays.asList(stringBuilder.toString().split(";")));
    }

    public static void write(String fileName, List<String> text) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            PrintWriter printWriter = new PrintWriter(file.getAbsoluteFile());
            int counter = 0;
            try {
                while (counter < text.size()) {
                    printWriter.println(text.get(counter));
                    counter++;
                }
            } finally {
                printWriter.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
