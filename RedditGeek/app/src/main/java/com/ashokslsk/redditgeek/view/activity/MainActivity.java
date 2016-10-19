package com.ashokslsk.redditgeek.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ashokslsk.redditgeek.R;
import com.ashokslsk.redditgeek.view.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        }
    }
}
