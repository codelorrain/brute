package com.niemisami.brute.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.niemisami.brute.models.Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sami on 9/3/16.
 */
public class ExerciseItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = ExerciseItemAdapter.class.getSimpleName();

    private Context mContext;
    private List<Exercise> mExercises;

    public ExerciseItemAdapter(Context context) {
        mContext = context;
    }

    public void setExercises(List<Exercise> exercises) {
        mExercises = exercises;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ExerciseItemView exerciseItemView = new ExerciseItemView(mContext);
        return new ExerciseItemViewHolder(exerciseItemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ExerciseItemViewHolder exerciseItemViewHolder = (ExerciseItemViewHolder) holder;
        Exercise exercise = mExercises.get(position);
        exerciseItemViewHolder.setExerciseName(exercise.getName());
        exerciseItemViewHolder.setReps(exercise.getReps());
        exerciseItemViewHolder.setSets(exercise.getSets());
        exerciseItemViewHolder.setWeight(exercise.getWeight());
    }


    @Override
    public int getItemCount() {
        if (mExercises == null) {
            return 0;
        }
        return mExercises.size();
    }
}
