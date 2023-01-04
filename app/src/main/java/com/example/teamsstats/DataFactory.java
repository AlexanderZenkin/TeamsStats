package com.example.teamsstats;

import com.example.teamsstats.interfaces.APIService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class DataFactory {

    private static APIService apiService;

    public static APIService getData() {
        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.football-data.org/v4/")
                    .addConverterFactory(JacksonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
            apiService = retrofit.create(APIService.class);
        }
        return apiService;
    }
}
