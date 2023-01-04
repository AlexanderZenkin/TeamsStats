package com.example.teamsstats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamsstats.activiti_model.TableActivityModel;
import com.example.teamsstats.model.TableList;
import com.example.teamsstats.model.dto.full_model.FullModelTournamentTable;

public class TableActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ViewActivity";

    private TableList tableList;
    private TextView tournamentTableTv;
    private TableRow tournamentTableHeaderTv;
    private int count = 0;

    private Toast toastError;

    private TableActivityModel tableActivityModel;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_table);

        Button getMatchesAll = findViewById(R.id.total_matches);
        getMatchesAll.setOnClickListener(this);

        Button getMatchesHome = findViewById(R.id.matches_home);
        getMatchesHome.setOnClickListener(this);

        Button getMatchesAway = findViewById(R.id.matches_away);
        getMatchesAway.setOnClickListener(this);

        tournamentTableTv = findViewById(R.id.tournament_table_tv);
        tournamentTableHeaderTv = findViewById(R.id.tournament_table_header_tv);
    }

    public void getTournamentTable(String competitions) {

        tableActivityModel = new ViewModelProvider(this).get(TableActivityModel.class);
        tableActivityModel.loadTournamentTable(competitions);
        tableActivityModel.getMutableLiveData().observe(this, new Observer<FullModelTournamentTable>() {
            @Override
            public void onChanged(FullModelTournamentTable fullModelTournamentTable) {

                JsonParser jsonParser = new JsonParser();
                tableList = jsonParser.inflateTableList(fullModelTournamentTable, count);
                setView(tableList);
            }
        });
    }

    public void setView(TableList tableList) {

        RecyclerView recyclerView = findViewById(R.id.recycler_view_tournament_table);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new AdapterTournamentTable(tableList, tableList.tableList.length));
    }

    @Override
    public void onClick(View view) {

        Intent intent = getIntent();
        String idCompetition = intent.getStringExtra("idCompetition");

        switch (view.getId()) {
            case R.id.total_matches:
                count = 0;
                getTournamentTable(idCompetition);
                tournamentTableTv.setVisibility(View.VISIBLE);
                tournamentTableHeaderTv.setVisibility(View.VISIBLE);
                break;

            case R.id.matches_home:
                count = 1;
                getTournamentTable(idCompetition);
                tournamentTableTv.setVisibility(View.VISIBLE);
                tournamentTableHeaderTv.setVisibility(View.VISIBLE);
                break;

            case R.id.matches_away:
                count = 2;
                getTournamentTable(idCompetition);
                tournamentTableTv.setVisibility(View.VISIBLE);
                tournamentTableHeaderTv.setVisibility(View.VISIBLE);
                break;
        }
    }
}
