package com.niemisami.brute.models;

import java.util.ArrayList;

/**
 * Created by esa on 9/3/16.
 */
public class ExerciseGroup {
    private int mID;
    private String name;
    private ArrayList<Exercise> mExercises;

    public ExerciseGroup() {
        mExercises = new ArrayList<Exercise>();
    }

    public int getID() {
        return mID;
    }

    public void setID(int ID) {
        mID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Exercise> getExercises() {
        return mExercises;
    }

    public void addExercise(Exercise e) {
        mExercises.add(e);
    }

    public void removeExercise(Exercise e) {
        mExercises.remove(e);
    }
}
