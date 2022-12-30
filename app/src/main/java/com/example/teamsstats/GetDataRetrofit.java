package com.example.teamsstats;

import com.example.teamsstats.interfaces.APIService;
import com.example.teamsstats.model.dto.full_model.FullModelH2HMatches;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class GetDataRetrofit {

    public FullModelH2HMatches getDataH2HMatches(String matchId, String limit) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.football-data.org/v4/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        APIService userService = retrofit.create(APIService.class);
        return userService.getH2HMatches(matchId, limit).execute().body();
    }
}
