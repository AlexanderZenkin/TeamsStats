package com.example.teamsstats;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamsstats.activiti_model.ViewActivityModel;
import com.example.teamsstats.interfaces.ListItemClickListener;
import com.example.teamsstats.model.ListMatches;
import com.example.teamsstats.model.dto.full_model.FullModelH2HMatches;

public class ViewActivity extends AppCompatActivity implements ListItemClickListener, View.OnClickListener {

    private static final String TAG = "TableActivity";

    private Button stake;
    private String matchId;
    private String idHomeTeam;
    private String idAwayTeam;
    private String idCompetition;
    private ListMatches matches;

    private ViewActivityModel viewActivityModel;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Button searchLastMatchesHomeTeam = findViewById(R.id.h_2_h_matches);
        searchLastMatchesHomeTeam.setOnClickListener(this);

        stake = findViewById(R.id.stavka);
        stake.setOnClickListener(this);

        Button getTournamentTable = findViewById(R.id.turnament_table);
        getTournamentTable.setOnClickListener(this);

        Button searchH2HMatches = findViewById(R.id.home_team_matches);
        searchH2HMatches.setOnClickListener(this);

        Button searchLastAwayTeamMatches = findViewById(R.id.last_away_team_matches);
        searchLastAwayTeamMatches.setOnClickListener(this);

        Button searchLastHomeTeamMatches = findViewById(R.id.last_home_team_matches);
        searchLastHomeTeamMatches.setOnClickListener(this);

        Button searchLastMatchesAwayTeam = findViewById(R.id.away_team_matches);
        searchLastMatchesAwayTeam.setOnClickListener(this);
    }

    @Override
    public void onListItemClick(int clickItemIndex) {

    }

    public void getDataStatisticH2H() {

        viewActivityModel = new ViewModelProvider(this).get(ViewActivityModel.class);
        viewActivityModel.loadH2HMatches(matchId);
        viewActivityModel.getMutableLiveData().observe(this, new Observer<FullModelH2HMatches>() {
            @Override
            public void onChanged(FullModelH2HMatches fullModelH2HMatches) {
                Log.d(TAG, "ViewActivity_in_model_h2h: " + fullModelH2HMatches.toString());

                JsonParser jsonParser = new JsonParser();
                matches = jsonParser.inflateListMatches(fullModelH2HMatches);
                setView(R.id.recycler_view, matches);
                Log.d(TAG, "ViewActivity_matches_list_h2h: " + matches.toString());
            }
        });
    }

    public void getStatisticHomeAndAway(String idTeam, String competitions,String venue) {

        viewActivityModel = new ViewModelProvider(this).get(ViewActivityModel.class);
        viewActivityModel.loadHomeAndAwayMatches(idTeam,competitions, venue);
        viewActivityModel.getMutableLiveData().observe(this, new Observer<FullModelH2HMatches>() {
            @Override
            public void onChanged(FullModelH2HMatches fullModelH2HMatches) {
                Log.d(TAG, "ViewActivity_in_model_home_away: " + fullModelH2HMatches.toString());

                JsonParser jsonParser = new JsonParser();
                matches = jsonParser.inflateListMatches(fullModelH2HMatches);
                setView(R.id.recycler_view, matches);
                Log.d(TAG, "ViewActivity_matches_list_home_away: " + matches.toString());
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

        Intent intent = getIntent();
        matchId = intent.getStringExtra("matchId");
        idHomeTeam = intent.getStringExtra("idHomeTeam");
        idAwayTeam = intent.getStringExtra("idAwayTeam");
        idCompetition = intent.getStringExtra("idCompetition");

        switch (view.getId()) {
            case R.id.h_2_h_matches:
                getDataStatisticH2H();
                stake.setVisibility(View.VISIBLE);
                break;

            case R.id.home_team_matches:
                getStatisticHomeAndAway(idHomeTeam, idCompetition, "HOME");
                stake.setVisibility(View.VISIBLE);
                break;

            case R.id.away_team_matches:
                getStatisticHomeAndAway(idAwayTeam, idCompetition, "AWAY");
                stake.setVisibility(View.VISIBLE);
                break;

            case R.id.last_home_team_matches:
                getStatisticHomeAndAway(idHomeTeam, idCompetition, null);
                stake.setVisibility(View.VISIBLE);
                break;

            case R.id.last_away_team_matches:_team_matches:
                getStatisticHomeAndAway(idAwayTeam, idCompetition, null);
                stake.setVisibility(View.VISIBLE);
                break;

            case R.id.turnament_table:
                Intent newIntent = new Intent(ViewActivity.this, TableActivity.class);
                newIntent.putExtra("idCompetition", idCompetition);
                startActivity(newIntent);
                break;

            case R.id.stavka:
                Uri address = Uri.parse("https://www.marathonbet.ru/");
                Intent openLink = new Intent(Intent.ACTION_VIEW, address);
                startActivity(openLink);
                break;
        }
    }
}
