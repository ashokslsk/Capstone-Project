package com.ashokslsk.redditgeek.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ashokslsk.redditgeek.R;
import com.ashokslsk.redditgeek.model.TopnewsResponse;
import com.ashokslsk.redditgeek.network.RedditnewService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

            TopnewsResponse mResponse;
            private static final String TAG = "MainActivity";

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                getTopRedditNews();
            }

            private void getTopRedditNews() {
                Retrofit retrofit = new Retrofit.Builder()
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("https://www.reddit.com")
                        .build();

                RedditnewService TopNewsService = retrofit.create(RedditnewService.class);
                Observable<TopnewsResponse> TopNews = TopNewsService.getTopNews("30");

                TopNews.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<TopnewsResponse>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(TopnewsResponse topnewsResponse) {
                                Log.d(TAG, "onNext() called with: topnewsResponse = [" + topnewsResponse.getData().getChildren().get(22).getData().getTitle() + "]");
                            }
                        });
            }
}
