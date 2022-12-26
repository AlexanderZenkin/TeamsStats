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
import com.example.teamsstats.model.DateTimeFormatter;
import com.example.teamsstats.model.ListMatches;

import org.json.JSONException;

import java.net.URL;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AsyncResponse, ListItemClickListener {

    private static final String TAG = "MainActivity";
    private ListMatches matches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchLeagueChampions = findViewById(R.id.search_league_champions);
        searchLeagueChampions.setOnClickListener(this);

        Button searchBundesLeague = findViewById(R.id.search_league_germany);
        searchBundesLeague.setOnClickListener(this);

        Button searchPremierLeague = findViewById(R.id.search_league_england);
        searchPremierLeague.setOnClickListener(this);

        Button searchLeagueA = findViewById(R.id.search_league_italy);
        searchLeagueA.setOnClickListener(this);

        Button searchLeagueFrance = findViewById(R.id.search_Ligue_1);
        searchLeagueFrance.setOnClickListener(this);

        Button searchNetherlands = findViewById(R.id.search_league_eredivisie);
        searchNetherlands.setOnClickListener(this);

        Button searchSpain = findViewById(R.id.search_league_spain);
        searchSpain.setOnClickListener(this);

        Button searchPortugal = findViewById(R.id.search_primeira_liga);
        searchPortugal.setOnClickListener(this);
    }

    @Override
    public void processFinish(String output) {
        Log.d(TAG, "processFinish: " + output);

        try {

            JsonParser jsonParser = new JsonParser();
            matches = jsonParser.gsonParser(output);
            setView(R.id.recycler_view, matches);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setView(int id, ListMatches listMatches) {

        RecyclerView recyclerView = findViewById(id);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new AdapterMatchesList(listMatches, listMatches.listMatches.length, this));
    }

    @Override
    public void onClick(View view) {

        DateTimeFormatter dateTimeFormatter = new DateTimeFormatter();
        String matchDayFrom = dateTimeFormatter.dateTimeFormatter(new Date(), 0);
        String matchDayTo = dateTimeFormatter.dateTimeFormatter(new Date(), 7);

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

        String id = matches.listMatches[clickItemIndex].getMatchId();
        Intent intent = new Intent(this, ViewActivity.class);
        intent.putExtra("matchId", id);
        intent.putExtra("idHomeTeam", matches.listMatches[clickItemIndex].getIdHomeTeam());
        intent.putExtra("idAwayTeam", matches.listMatches[clickItemIndex].getIdAwayTeam());
        intent.putExtra("idCompetition", matches.listMatches[clickItemIndex].getIdCompetition());
        startActivity(intent);
    }
}