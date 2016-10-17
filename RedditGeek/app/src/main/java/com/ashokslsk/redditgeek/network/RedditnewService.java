package com.ashokslsk.redditgeek.network;

import com.ashokslsk.redditgeek.model.TopnewsResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ashok.kumar on 17/10/16.
 */

public interface RedditnewService {

    @GET("new.json")
    Observable<TopnewsResponse> getTopNews(@Query("limit") String numbers);

}
