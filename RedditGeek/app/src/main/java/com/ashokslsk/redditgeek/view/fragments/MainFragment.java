package com.ashokslsk.redditgeek.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashokslsk.redditgeek.R;
import com.ashokslsk.redditgeek.adapters.TopNewsAdapter;
import com.ashokslsk.redditgeek.model.TopnewsResponse;
import com.ashokslsk.redditgeek.network.RedditnewService;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ashok.kumar on 19/10/16.
 */

public class MainFragment extends Fragment {


    private static final String TAG = "MainFragment";
    private RecyclerView mTopnews_Recyclerview;
    private TopNewsAdapter mAdapter;
    private List<TopnewsResponse.DataEntity.ChildrenEntity> mDataEntity;

    public MainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTopnews_Recyclerview = (RecyclerView) getView().findViewById(R.id.myList);
        mTopnews_Recyclerview.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mTopnews_Recyclerview.setLayoutManager(llm);
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
//                        mAdapter = new TopNewsAdapter(topnewsResponse.getData().getChildren());
                        mAdapter = new TopNewsAdapter(getActivity().getApplicationContext(),topnewsResponse.getData().getChildren());
                        mTopnews_Recyclerview.setAdapter(mAdapter);
                    }
                });
    }
}
