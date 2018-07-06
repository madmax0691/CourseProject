package com.mkaz.io.serializing;

import com.mkaz.Game;

import java.io.*;

public class Serializing {
    public static void write(String fileName, Game game) {
        try (FileOutputStream fileOut =
                     new FileOutputStream(fileName)) {
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(game);
                System.out.println("Done! " + game.getTitle());
            } catch (IOException i) {
                i.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Game read(String fileName) {
        Game game = null;
        try (FileInputStream fileIn = new FileInputStream(fileName)) {
            try (ObjectInputStream in = new ObjectInputStream(fileIn)) {
                game = (Game) in.readObject();
            } catch (IOException i) {
                i.printStackTrace();
            } catch (ClassNotFoundException c) {
                System.out.println("Class not found!");
                c.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return game;
    }

    private static byte[] toByteArray(Game game) throws IOException {
        byte[] bytes;
        try (ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream()) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(arrayOutputStream)) {
                objectOutputStream.writeObject(game);
                objectOutputStream.flush();
                bytes = arrayOutputStream.toByteArray();
            }
        }
        return bytes;
    }
}
