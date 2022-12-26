package com.example.teamsstats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamsstats.interfaces.AsyncResponse;
import com.example.teamsstats.model.TableList;

import org.json.JSONException;

import java.net.URL;

public class TableActivity extends Activity implements AsyncResponse, View.OnClickListener {

    private static final String TAG = "ViewActivity";

    private Button getMatchesAll;
    private Button getMatchesHome;
    private Button getMatchesAway;

    private TableList tableList;
    private TextView tournamentTableTv;
    private TableRow tournamentTableHeaderTv;
    private int count = 0;

    private Toast toastError;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_table);

        getMatchesAll = findViewById(R.id.total_matches);
        getMatchesAll.setOnClickListener(this);

        getMatchesHome = findViewById(R.id.matches_home);
        getMatchesHome.setOnClickListener(this);

        getMatchesAway = findViewById(R.id.matches_away);
        getMatchesAway.setOnClickListener(this);

        tournamentTableTv = findViewById(R.id.tournament_table_tv);
        tournamentTableHeaderTv = findViewById(R.id.tournament_table_header_tv);
    }


    @Override
    public void processFinish(String output) {

        Log.d(TAG, "processFinish: " + output);

        if (output.equals("noResult")) {
            int duration = Toast.LENGTH_LONG;
            if (toastError != null) {
                toastError.cancel();
            }
            toastError = Toast.makeText(this, R.string.ResponseLimit, duration);
            toastError.show();
        }

        try {
            JsonParser jsonParser = new JsonParser();
            tableList = jsonParser.gsonParserTable(output, count);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        RecyclerView recyclerView = findViewById(R.id.recycler_view_tournament_table);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new AdapterTournamentTable(tableList, tableList.tableList.length));
    }

    @Override
    public void onClick(View view) {

        Intent intent = getIntent();
        String idCompetition = intent.getStringExtra("idCompetition");

        UrlBuilder urlBuilder = new UrlBuilder();
        URL url;

        GetData getData = new GetData(this);

        switch (view.getId()) {
            case R.id.total_matches:
                count = 0;
                url = urlBuilder.builderUrlTournamentTable(idCompetition);
                getData.execute(url);
                tournamentTableTv.setVisibility(View.VISIBLE);
                tournamentTableHeaderTv.setVisibility(View.VISIBLE);
                break;

            case R.id.matches_home:
                count = 1;
                url = urlBuilder.builderUrlTournamentTable(idCompetition);
                getData.execute(url);
                tournamentTableTv.setVisibility(View.VISIBLE);
                tournamentTableHeaderTv.setVisibility(View.VISIBLE);
                break;

            case R.id.matches_away:
                count = 2;
                url = urlBuilder.builderUrlTournamentTable(idCompetition);
                getData.execute(url);
                tournamentTableTv.setVisibility(View.VISIBLE);
                tournamentTableHeaderTv.setVisibility(View.VISIBLE);
                break;
        }
    }
}
