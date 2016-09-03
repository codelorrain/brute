package com.niemisami.brute;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.niemisami.brute.models.Exercise;
import com.niemisami.brute.views.MainFragment;
import com.niemisami.brute.views.OnBruteFabClicklistener;
import com.niemisami.brute.views.excercise_information.ExerciseFragment;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout mRootLayout;
    private OnBruteFabClicklistener mOnBruteFabClicklistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflateFragments();
        initView();
    }

    private void initView() {
        mRootLayout = (CoordinatorLayout) findViewById(R.id.app_root_layout);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        if (floatingActionButton != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnBruteFabClicklistener.onBruteFabClicked();
                    showSnackbar("ExerciseFragment: Fab Clicked");
                }
            });
        }
    }

    private void showSnackbar(String message) {
        final Snackbar snackbar = Snackbar.make(mRootLayout, message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }


    /**
     * Find fragment layout and add it to the activity
     */
    private void inflateFragments() {
        FragmentManager manager = getSupportFragmentManager();
        if (manager.findFragmentById(R.id.container_body) == null) {
            MainFragment fragment = new MainFragment();
//            ExerciseFragment fragment = new ExerciseFragment();
            mOnBruteFabClicklistener = fragment;
            manager.beginTransaction()
                    .add(R.id.container_body, fragment)
                    .commit();
        }
    }

    public void startExerciseFragment(long id) {

        FragmentManager manager = getSupportFragmentManager();
        if (manager.findFragmentById(R.id.container_body) == null) {
//            MainFragment fragment = new MainFragment();

            ExerciseFragment fragment = ExerciseFragment.newInstance(id);
            mOnBruteFabClicklistener = fragment;
            manager.beginTransaction()
                    .add(R.id.container_body, fragment)
                    .commit();
        }

    }
}
