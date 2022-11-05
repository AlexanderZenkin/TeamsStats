package com.example.teamsstats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamsstats.interfaces.AsyncResponse;
import com.example.teamsstats.model.TableList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class TableActivity extends Activity implements AsyncResponse {

    private static final String TAG = "ViewActivity";

    private TableList tableList;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_table);

        Intent intent = getIntent();
        String idCompetition = intent.getStringExtra("idCompetition");

        UrlBuilder urlBuilder = new UrlBuilder();
        URL url = urlBuilder.builderUrlTournamentTable(idCompetition);

        GetData getData = new GetData(this);
        getData.execute(url);
    }


    @Override
    public void processFinish(String output) {

        Log.d(TAG, "processFinish: " + output);

        try {
            JSONObject resultJson = new JSONObject(output);
            JSONArray table = resultJson.getJSONArray("standings").getJSONObject(0).getJSONArray("table");

            tableList = new TableList(table.length());

            for (int i = 0; i < table.length(); i++) {

                String teamPosition = table.getJSONObject(i).getString("position");
                String homeTeamName = table.getJSONObject(i).getJSONObject("team").getString("shortName");
                String playedGames = table.getJSONObject(i).getString("playedGames");

                tableList.addMatch(teamPosition, homeTeamName, playedGames, i);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        RecyclerView recyclerView = findViewById(R.id.recycler_view_tournament_table);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new AdapterTournamentTable(tableList, tableList.tableList.length));
    }
}
