package com.example.teamsstats.interfaces;

import com.example.teamsstats.model.dto.full_model.FullModelH2HMatches;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {


    @Headers({"X-Auth-Token: ed3016c610724551a0baa9812c3b78cf"})
    @GET("matches/{match}/head2head")
    Call<FullModelH2HMatches> getH2HMatches(
            @Path("match") String h2hMatchID,
            @Query("limit") String limit
    );

//    .appendPath("matches")
//                .appendPath(match)
//                .appendPath("head2head")
//                .appendQueryParameter("limit", "6")
}
