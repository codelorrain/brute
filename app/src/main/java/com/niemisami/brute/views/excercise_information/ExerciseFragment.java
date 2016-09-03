package com.niemisami.brute.views.excercise_information;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.niemisami.brute.R;
import com.niemisami.brute.models.Exercise;
import com.niemisami.brute.views.OnBruteFabClicklistener;

/**
 * Created by niemisami 3.9.2016
 */
public class ExerciseFragment extends Fragment implements OnBruteFabClicklistener {

    private static final String TAG = ExerciseFragment.class.getSimpleName();
    public static final String ARG_EXERCISE_ID = "arg_exercise_id";

    private Exercise mExercise;
    private ImageView mExerciseIcon;
    private TextView mExerciseName, mRepsView, mSetsView, mWeightsView;
    private Button mAddRepButton, mSubstrackRepButton;
    private int mExerciseID;

    public ExerciseFragment() {
    }

    public static ExerciseFragment newInstance(long exerciseID) {
        ExerciseFragment fragment = new ExerciseFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_EXERCISE_ID, (int)exerciseID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mExerciseID = getArguments().getInt(ARG_EXERCISE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_excercise_view, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {

    }

    @Override
    public void onBruteFabClicked() {
        Log.d(TAG, "onBruteFabClicked: ");
    }


}
