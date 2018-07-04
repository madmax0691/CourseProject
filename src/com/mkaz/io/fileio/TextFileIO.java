package com.mkaz.io.fileio;

import java.io.*;
import java.util.List;

public class TextFileIO {

    public static String read(String fileName, String splitter) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                new File(fileName).getAbsoluteFile()))) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                stringBuilder.append(s);
                stringBuilder.append(splitter);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    public static void write(String fileName, List<String> list) {
        File file = new File(fileName);
        try (PrintWriter printWriter = new PrintWriter(file.getAbsoluteFile())) {
            for (String s : list) {
                printWriter.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createFile(String fileName) {
        File file = new File(fileName);
        try {
            boolean newFile = file.createNewFile();
            if (newFile) {
                System.out.println("File: " + fileName + " has created!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
