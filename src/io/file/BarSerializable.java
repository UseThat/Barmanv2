package io.file;

import model.Drink;

import java.io.*;

public class BarSerializable {
    private static final String FILE_NAME = "Bar.obj";

    public void exportData(Drink[] drink) {
        try (FileOutputStream out = new FileOutputStream(FILE_NAME);
             ObjectOutputStream outStream = new ObjectOutputStream(out);) {
            outStream.writeObject(drink);
        } catch (IOException ex) {
            System.out.println("no File");
        }
    }

    public Drink[] importData() throws IOException {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            return (Drink []) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("No File");
            throw new IOException();

        }

    }
}
