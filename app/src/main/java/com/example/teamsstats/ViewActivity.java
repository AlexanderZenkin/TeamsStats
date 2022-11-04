package com.example.teamsstats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamsstats.interfaces.AsyncResponse;
import com.example.teamsstats.interfaces.ListItemClickListener;
import com.example.teamsstats.model.ListMatches;

import org.json.JSONException;

import java.net.URL;

public class ViewActivity extends Activity implements AsyncResponse, ListItemClickListener, View.OnClickListener {

    private static final String TAG = "ViewActivity";

    private Button searchLastMatchesHomeTeam;
    private Button searchH2HMatches;
    private Button searchLastMatchesAwayTeam;

    private String matchId;
    private String idHomeTeam;
    private String idAwayTeam;
    private ListMatches matches;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        searchLastMatchesHomeTeam = findViewById(R.id.h_2_h_matches);
        searchLastMatchesHomeTeam.setOnClickListener(this);

        searchH2HMatches = findViewById(R.id.home_team_matches);
        searchH2HMatches.setOnClickListener(this);

        searchLastMatchesAwayTeam = findViewById(R.id.away_team_matches);
        searchLastMatchesAwayTeam.setOnClickListener(this);
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

    @Override
    public void onListItemClick(int clickItemIndex) {

    }

    public void setView(int id, ListMatches listMatches) {

        RecyclerView recyclerView = findViewById(id);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new MyAdapter(listMatches, listMatches.listMatches.length, this));
    }

    @Override
    public void onClick(View view) {

        Intent intent = getIntent();
        matchId = intent.getStringExtra("matchId");
        idHomeTeam = intent.getStringExtra("homeTeamId");
        idAwayTeam = intent.getStringExtra("awayTeamId");

        UrlBuilder urlBuilder = new UrlBuilder();
        URL url;
        GetData getData = new GetData(this);

        switch (view.getId()) {
            case R.id.h_2_h_matches:
                url = urlBuilder.builderUrlH2HMatches(matchId);
                getData.execute(url);
                break;

            case R.id.home_team_matches:
                url = urlBuilder.builderUrlMatchesHomeTeam(idHomeTeam, "2021", "HOME");
                getData.execute(url);
                break;

            case R.id.away_team_matches:
                url = urlBuilder.builderUrlMatchesHomeTeam(idAwayTeam, "2021", "AWAY");
                getData.execute(url);
                break;
        }
    }
}
