package com.example.teamsstats;

import static org.junit.Assert.assertEquals;

import com.example.teamsstats.interfaces.APIService;

import org.junit.Test;

import java.io.IOException;

import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testRetrofit() throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.football-data.org/v4/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        APIService userService = retrofit.create(APIService.class);
        Request test = userService.getUser("2021").execute().raw().request();

        System.out.println("stop");
    }
}