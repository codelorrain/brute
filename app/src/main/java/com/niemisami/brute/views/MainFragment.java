package com.niemisami.brute.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.niemisami.brute.R;
import com.niemisami.brute.models.Exercise;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    private RecyclerView mRecyclerView;
    private ExerciseItemAdapter mAdapter;
    private List<Exercise> mExercises;

    public MainFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new ExerciseItemAdapter(getActivity());
        fetchExercises();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        initViews(view);

        return view;
    }


    private void initViews(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.exercise_recycler_view);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true); // improves recycler view's performance
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

    }

    private void fetchExercises() {
        mExercises = new ArrayList<>();
        Exercise test = new Exercise();
        test.setName("Testiliike");
        mExercises.add(test);
        mExercises.add(test);
        mExercises.add(test);
        mExercises.add(test);
        mExercises.add(test);
        mExercises.add(test);
        mExercises.add(test);
        mExercises.add(test);
        mAdapter.setExercises(mExercises);
    }


}
