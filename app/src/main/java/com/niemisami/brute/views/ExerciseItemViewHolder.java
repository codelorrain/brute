package com.niemisami.brute.views;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by sami on 9/3/16.
 */
public class ExerciseItemViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = ExerciseItemViewHolder.class.getSimpleName();
    private ExerciseItemView mExerciseItemView;

    public ExerciseItemViewHolder(ExerciseItemView exerciseItemView) {
        super(exerciseItemView);
        mExerciseItemView = exerciseItemView;
    }

    public void setExerciseName(String name) {
        mExerciseItemView.setExerciseName(name);
    }
}
