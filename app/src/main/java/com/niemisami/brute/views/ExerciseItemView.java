package com.niemisami.brute.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.niemisami.brute.R;

/**
 * Created by sami on 9/3/16.
 */
public class ExerciseItemView extends LinearLayout {

    public TextView mNameView;

    public ExerciseItemView(Context context) {
        this(context, null);
    }

    public ExerciseItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExerciseItemView(Context context, AttributeSet attrs, int defStyle) {
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
}
