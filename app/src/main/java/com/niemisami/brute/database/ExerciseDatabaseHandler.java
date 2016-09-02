package com.niemisami.brute.database;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.niemisami.brute.models.Exercise;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by esa on 9/3/16.
 */
public class ExerciseDatabaseHandler {

    private static final String TAG = ExerciseDatabaseHandler.class.getSimpleName();

    public ExerciseDatabaseHandler() {}

    public void writeExerciseToDatabase(Exercise e) {
        try {
            File root = new File(Environment.getExternalStorageDirectory(), "exercises");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, e.getName() + ".txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(
                    e.getTimestamp().toString() + "\t" +
                            e.getID() + "\t" +
                            e.getName() + "\t" +
                            e.getSets() + "\t" +
                            e.getReps() + "\t" +
                            e.getWeight());
            writer.flush();
            writer.close();
            Log.d(TAG, "Exercise data saved!");
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
