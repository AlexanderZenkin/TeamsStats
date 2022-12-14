package com.example.teamsstats.interfaces;

import com.example.teamsstats.model.TableStandings;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface APIService {


    @Headers({"X-Auth-Token: ed3016c610724551a0baa9812c3b78cf"})
    @GET("competitions/{competitions}/standings")
    Call<TableStandings> getUser(
            @Path("competitions") String competitions
    );
}
