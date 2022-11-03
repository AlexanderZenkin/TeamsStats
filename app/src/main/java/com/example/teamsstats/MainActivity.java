package com.example.teamsstats;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamsstats.interfaces.AsyncResponse;
import com.example.teamsstats.interfaces.ListItemClickListener;
import com.example.teamsstats.model.DateTimeFormater;
import com.example.teamsstats.model.ListMatches;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.time.Duration;
import java.time.Instant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AsyncResponse, ListItemClickListener {

    private static final String TAG = "MainActivity";
    private ListMatches matchList;

    private Button searchLeagueChampions;
    private Button searchBundesLeague;
    private Button searchPremierLeague;
    private Button searchLeagueA;

    private Button searchLeagueFrance;
    private Button searchNetherlands;
    private Button searchSpain;
    private Button searchPortugal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchLeagueChampions = findViewById(R.id.search_league_champions);
        searchLeagueChampions.setOnClickListener(this);

        searchBundesLeague = findViewById(R.id.search_league_germany);
        searchBundesLeague.setOnClickListener(this);

        searchPremierLeague = findViewById(R.id.search_league_england);
        searchPremierLeague.setOnClickListener(this);

        searchLeagueA = findViewById(R.id.search_league_italy);
        searchLeagueA.setOnClickListener(this);

        searchLeagueFrance = findViewById(R.id.search_Ligue_1);
        searchLeagueFrance.setOnClickListener(this);

        searchNetherlands = findViewById(R.id.search_league_eredivisie);
        searchNetherlands.setOnClickListener(this);

        searchSpain = findViewById(R.id.search_league_spain);
        searchSpain.setOnClickListener(this);

        searchPortugal = findViewById(R.id.search_primeira_liga);
        searchPortugal.setOnClickListener(this);
    }

    @Override
    public void processFinish(String output) {
        Log.d(TAG, "processFinish: " + output);

        try {

            JSONObject resultJson = new JSONObject(output);
            JSONArray matches = resultJson.getJSONArray("matches");

            matchList = new ListMatches(matches.length());

            for (int i = 0; i < matches.length(); i++) {

                String matchId = matches.getJSONObject(i).getString("id");

                JSONObject objH = matches.getJSONObject(i).getJSONObject("homeTeam");
                String homeTeamName = objH.getString("shortName");

                JSONObject objA = matches.getJSONObject(i).getJSONObject("awayTeam");
                String awayTeamName = objA.getString("shortName");

                matchList.addMatch(homeTeamName, awayTeamName, "-" + ":" + "-", matchId, i);
            }

            RecyclerView recyclerView = findViewById(R.id.recycler_view);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(new MyAdapter(matchList, matches.length(), this));


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {

        String matchDayFrom = DateTimeFormater.dateTimeFormatter(Instant.now().getEpochSecond(), "yyyy-MM-dd");
        String matchDayTo = DateTimeFormater.dateTimeFormatter(Instant.now().plus(Duration.ofDays(5)).getEpochSecond(), "yyyy-MM-dd");
        UrlBuilder urlBuilder = new UrlBuilder();
        URL url;
        GetData getData = new GetData(this);

        switch (view.getId()) {
            case R.id.search_league_champions:
                url = urlBuilder.builderUrlCLMatches(matchDayFrom, matchDayTo, "2001");
                getData.execute(url);
                break;

            case R.id.search_league_germany:
                url = urlBuilder.builderUrlCLMatches(matchDayFrom, matchDayTo, "2002");
                getData.execute(url);
                break;

            case R.id.search_league_england:
                url = urlBuilder.builderUrlCLMatches(matchDayFrom, matchDayTo, "2021");
                getData.execute(url);
                break;

            case R.id.search_league_italy:
                url = urlBuilder.builderUrlCLMatches(matchDayFrom, matchDayTo, "2019");
                getData.execute(url);
                break;

            case R.id.search_league_eredivisie:
                url = urlBuilder.builderUrlCLMatches(matchDayFrom, matchDayTo, "2003");
                getData.execute(url);
                break;

            case R.id.search_league_spain:
                url = urlBuilder.builderUrlCLMatches(matchDayFrom, matchDayTo, "2014");
                getData.execute(url);
                break;

            case R.id.search_primeira_liga:
                url = urlBuilder.builderUrlCLMatches(matchDayFrom, matchDayTo, "2017");
                getData.execute(url);
                break;

            case R.id.search_Ligue_1:
                url = urlBuilder.builderUrlCLMatches(matchDayFrom, matchDayTo, "2015");
                getData.execute(url);
                break;
        }
    }

    @Override
    public void onListItemClick(int clickItemIndex) {

        String id = matchList.listMatches[clickItemIndex].getMatchId();
        Intent intent = new Intent(this, ViewActivity.class);
        intent.putExtra("matchId", id);
        startActivity(intent);
    }
}