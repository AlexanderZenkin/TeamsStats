package com.example.teamsstats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamsstats.activiti_model.MainActivityModel;
import com.example.teamsstats.interfaces.ListItemClickListener;
import com.example.teamsstats.model.DateTimeFormatter;
import com.example.teamsstats.model.ListMatches;
import com.example.teamsstats.model.dto.full_model.FullModelScheduledMatches;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ListItemClickListener {

    private ListMatches matches;

    private MainActivityModel mainActivityModel;
    private Toast toastError;

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

    public void getDataScheduledMatches(String competitions, String dateFrom, String dateTo, String status) {

        mainActivityModel = new ViewModelProvider(this).get(MainActivityModel.class);
        mainActivityModel.loadScheduledMatches(competitions, dateFrom, dateTo, status);
        mainActivityModel.getMutableLiveData().observe(this, new Observer<FullModelScheduledMatches>() {
            @Override
            public void onChanged(FullModelScheduledMatches fullModelScheduledMatches) {

                JsonParser jsonParser = new JsonParser();
                matches = jsonParser.inflateScheduledMatches(fullModelScheduledMatches);
                setView(R.id.recycler_view, matches);
            }
        });
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

        switch (view.getId()) {
            case R.id.search_league_champions:
                getDataScheduledMatches("2001", matchDayFrom, matchDayTo, "SCHEDULED");
                break;

            case R.id.search_league_germany:
                getDataScheduledMatches("2002", matchDayFrom, matchDayTo, "SCHEDULED");
                break;

            case R.id.search_league_england:
                getDataScheduledMatches("2021", matchDayFrom, matchDayTo, "SCHEDULED");
                break;

            case R.id.search_league_italy:
                getDataScheduledMatches("2019", matchDayFrom, matchDayTo, "SCHEDULED");
                break;

            case R.id.search_league_eredivisie:
                getDataScheduledMatches("2003", matchDayFrom, matchDayTo, "SCHEDULED");
                break;

            case R.id.search_league_spain:
                getDataScheduledMatches("2014", matchDayFrom, matchDayTo, "SCHEDULED");
                break;

            case R.id.search_primeira_liga:
                getDataScheduledMatches("2017", matchDayFrom, matchDayTo, "SCHEDULED");
                break;

            case R.id.search_Ligue_1:
                getDataScheduledMatches("2015", matchDayFrom, matchDayTo, "SCHEDULED");
                break;
        }
    }

    @Override
    public void onListItemClick(int clickItemIndex) {

        int duration = Toast.LENGTH_LONG;
        if (toastError != null) {
            toastError.cancel();
        }
        toastError = Toast.makeText(this, matches.listMatches[clickItemIndex].getHomeTeam(), duration);
        toastError.show();

        Intent intent = new Intent(this, ViewActivity.class);
        intent.putExtra("matchId", matches.listMatches[clickItemIndex].getMatchId());
        intent.putExtra("idHomeTeam", matches.listMatches[clickItemIndex].getIdHomeTeam());
        intent.putExtra("idAwayTeam", matches.listMatches[clickItemIndex].getIdAwayTeam());
        intent.putExtra("idCompetition", matches.listMatches[clickItemIndex].getIdCompetition());
        startActivity(intent);
    }
}