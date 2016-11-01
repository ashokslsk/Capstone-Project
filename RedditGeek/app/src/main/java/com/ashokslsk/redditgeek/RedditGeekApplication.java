package com.ashokslsk.redditgeek;

import android.app.Application;

import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by ashok.kumar on 17/10/16.
 */

public class RedditGeekApplication extends Application {

    private FirebaseAnalytics firebaseAnalytics;


    @Override
    public void onCreate() {
        super.onCreate();
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);

    }

}
