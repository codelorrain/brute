package com.niemisami.brute.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sami on 9/3/16.
 */
public class ExcerciseItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = ExcerciseItemAdapter.class.getSimpleName();

    private Context mContext;
    private List<Integer> mExercises;

    public ExcerciseItemAdapter(Context context) {
        mContext = context;
    }

    public void setExercises(List<Integer> exercises) {
        mExercises = new ArrayList<>();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ExerciseItemView exerciseItemView = new ExerciseItemView(mContext);
        return new ExerciseItemViewHolder(exerciseItemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {

    }

    @Override
    public int getItemCount() {
        if (mExercises == null) {
            return 0;
        }
        return mExercises.size();
    }
}
