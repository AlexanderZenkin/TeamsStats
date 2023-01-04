package com.example.teamsstats.interfaces;

import com.example.teamsstats.model.dto.full_model.FullModelH2HMatches;
import com.example.teamsstats.model.dto.full_model.FullModelScheduledMatches;
import com.example.teamsstats.model.dto.full_model.FullModelTournamentTable;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    String token = "X-Auth-Token: ed3016c610724551a0baa9812c3b78cf";


    @Headers({token})
    @GET("matches/{match}/head2head")
    Single<FullModelH2HMatches> getH2HMatches(
            @Path("match") String h2hMatchID,
            @Query("limit") String limit
    );

    @Headers({token})
    @GET("teams/{teamsId}/matches")
    Single<FullModelH2HMatches> getHomeAndAwayMatches(
            @Path("teamsId") String teamsId,
            @Query("limit") String limit,
            @Query("competitions") String competitions,
            @Query("status") String status,
            @Query("venue") String venue
    );

    @Headers({token})
    @GET("competitions/{competitions}/matches")
    Single<FullModelScheduledMatches> getScheduledMatches(
            @Path("competitions") String competitions,
            @Query("dateFrom") String dateFrom,
            @Query("dateTo") String dateTo,
            @Query("status") String status
    );

    @Headers({token})
    @GET("competitions/{competitions}/standings")
    Single<FullModelTournamentTable> getTournamentTable(
            @Path("competitions") String competitions
    );
}
