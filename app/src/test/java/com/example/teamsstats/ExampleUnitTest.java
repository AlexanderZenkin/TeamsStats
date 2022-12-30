package com.example.teamsstats;

import static org.junit.Assert.assertEquals;

import com.example.teamsstats.interfaces.APIService;
import com.example.teamsstats.model.dto.full_model.FullModelH2HMatches;

import org.junit.Test;

import java.io.IOException;

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
        FullModelH2HMatches test = userService.getH2HMatches("416242", "6").execute().body();

        System.out.println(test);
    }
}