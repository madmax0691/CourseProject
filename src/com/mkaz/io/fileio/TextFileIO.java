package com.mkaz.io.fileio;

import java.io.*;

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

    public static void write(String fileName, String text) {
        File file = new File(fileName);
        try {
            file.createNewFile();
            System.out.println("File: " + fileName + " has created!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (PrintWriter printWriter = new PrintWriter(file.getAbsoluteFile())) {
            printWriter.println(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
