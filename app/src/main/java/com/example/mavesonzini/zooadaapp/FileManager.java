package com.example.mavesonzini.zooadaapp;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static android.content.ContentValues.TAG;

/**
 * Created by mavesonzini on 05/02/2018.
 */

public class FileManager {
    private static final String FILE_NAME = "zoo.temp";
    private final Context context;

    public FileManager(Context context) {
        this.context = context;
    }

    public synchronized void writeZooToFile() {
        Log.i(TAG, "Writing zoo to file");

        try {
            FileOutputStream fileOutputStream = context.openFileOutput(FILE_NAME, context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(Zoo.getInstance());
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void getZooFromFile() {
        try {
            FileInputStream fileInputStream = context.openFileInput(FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Zoo zoo = (Zoo) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

            if (zoo != null) {
                Zoo.initializeZoo(zoo);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
