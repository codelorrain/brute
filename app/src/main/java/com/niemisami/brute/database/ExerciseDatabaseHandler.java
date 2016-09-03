package com.niemisami.brute.database;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.niemisami.brute.models.Exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by esa on 9/3/16.
 */
public class ExerciseDatabaseHandler {

    private static final String TAG = ExerciseDatabaseHandler.class.getSimpleName();

    public ExerciseDatabaseHandler() {}

    public void writeExerciseToDatabase(Exercise e) {
        try {
            File root = new File(Environment.getExternalStorageDirectory(), "brute");
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

    public ArrayList<Exercise> readExercisesFromDatabase(String fn) {

        ArrayList<Exercise> exercises = new ArrayList<>();
        File file = new File(Environment.getExternalStorageDirectory(), "/brute/" + fn);
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            /* Read the file until EOF */
            while ((line = br.readLine()) != null) {

                String[] data = line.split("\t");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Exercise e = new Exercise();

                try {
                    e.setTimestamp(dateFormat.parse(data[0]));
                } catch (ParseException pe) {
                    pe.printStackTrace();
                }
                e.setID(Integer.parseInt(data[1]));
                e.setName(data[2]);
                e.setSets(Integer.parseInt(data[3]));
                e.setReps(Integer.parseInt(data[4]));
                e.setWeight(Float.parseFloat(data[5]));

                exercises.add(e);
            }
            br.close();
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }

        return exercises;
    }
}
