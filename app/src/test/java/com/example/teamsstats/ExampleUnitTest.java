package com.example.teamsstats;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.io.IOException;

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

        var test = DataFactory.getData()
                .getHomeAndAwayMatches("63", "10",
                        "2021", "FINISHED", "AWAY");


        System.out.println(test);
    }
}