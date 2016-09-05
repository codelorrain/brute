package com.niemisami.brute.views.adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.niemisami.brute.R;

/**
 * Created by sami on 9/3/16.
 */
public class ExerciseRecyclerViewItem extends LinearLayout {

    public TextView mNameView, mRepsView, mWeightView, mSetsView;

    public ExerciseRecyclerViewItem(Context context) {
        this(context, null);
    }

    public ExerciseRecyclerViewItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExerciseRecyclerViewItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setupView();
    }

    private void setupView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.exercise_item, this);
        mNameView = (TextView) view.findViewById(R.id.exercise_item_label);

    }

    public void setExerciseName(String exerciseName) {
        mNameView.setText(exerciseName);
    }

    public void setReps(int reps) {
//        mRepsView.setText(Integer.toString(reps));
    }
    public void setSets(int sets) {
//        mSetsView.setText(sets);
    }

    public void setWeight(float weight) {
//        mWeightView.setText(String.format("%.2f", weight));
    }
}
