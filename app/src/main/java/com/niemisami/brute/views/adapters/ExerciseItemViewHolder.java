package com.niemisami.brute.views.adapters;

import android.support.v7.widget.RecyclerView;

/**
 * Created by sami on 9/3/16.
 */
public class ExerciseItemViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = ExerciseItemViewHolder.class.getSimpleName();
    private ExerciseRecyclerViewItem mExerciseRecyclerViewItem;

    public ExerciseItemViewHolder(ExerciseRecyclerViewItem exerciseRecyclerViewItem) {
        super(exerciseRecyclerViewItem);
        mExerciseRecyclerViewItem = exerciseRecyclerViewItem;
    }

    public void setExerciseName(String name) {
        mExerciseRecyclerViewItem.setExerciseName(name);
    }

    public void setReps(int reps) {
        mExerciseRecyclerViewItem.setReps(reps);
    }

    public void setSets(int sets) {
        mExerciseRecyclerViewItem.setSets(sets);
    }

    public void setWeight(float weight) {
        mExerciseRecyclerViewItem.setWeight(weight);
    }
}
