package com.niemisami.brute.views.excercise_information;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.niemisami.brute.R;

/**
 * Created by sami on 9/5/16.
 */
public class ExercisePropertyEditorLayout extends RelativeLayout implements View.OnClickListener {

    private static final String TAG = ExercisePropertyEditorLayout.class.getSimpleName();

    private OnExercisePropertiesClickListener mOnExerciseValueClickListener;
    private TextView mExerciseNameView, mValueView;
    private int mValue;

    public ExercisePropertyEditorLayout(Context context) {
        super(context);
        init(context);
    }

    public ExercisePropertyEditorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ExercisePropertyEditor,
                0, 0);
        try {
            mExerciseNameView.setText(typedArray.getString(R.styleable.ExercisePropertyEditor_propertyName));
            mValue = typedArray.getInt(R.styleable.ExercisePropertyEditor_propertyValue, 0);
        } finally {
            typedArray.recycle();
        }
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.exercise_properties_editor_view, this, true);
        mExerciseNameView = (TextView) findViewById(R.id.exercise_property);
        mValueView = (TextView) findViewById(R.id.exercise_property_value);

        Button subtractButton = (Button) findViewById(R.id.subtract_rep_button);
        subtractButton.setOnClickListener(this);
        Button addValueButton = (Button) findViewById(R.id.add_rep_button);
        addValueButton.setOnClickListener(this);

    }

    public void setOnExerciseValueClickListener(OnExercisePropertiesClickListener propertiesClickListener) {
        mOnExerciseValueClickListener = propertiesClickListener;
    }

    @Override
    public void onClick(View v) {
        try {
            if (v.getId() == R.id.add_rep_button) {
                mOnExerciseValueClickListener.onAddClicked(++mValue);
            } else if (v.getId() == R.id.subtract_rep_button) {
                mOnExerciseValueClickListener.onSubtractClicked(--mValue);
            } else {
                return;
            }
            setValue(mValue);
            Log.d(TAG, "onClick: values status " + mValue);
        } catch (NullPointerException e) {
            Log.e(TAG, "OnExercisePropertiesClickListener not determined", e);
        }
    }

    public void setExerciseName(String name) {
        mExerciseNameView.setText(name);
    }

    public void setValue(int value) {
        mValueView.setText(String.format("%d", value));
        mValue = value;
    }

    public interface OnExercisePropertiesClickListener {
        void onSubtractClicked(int result);
        void onAddClicked(int result);
    }
}

