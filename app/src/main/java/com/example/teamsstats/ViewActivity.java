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

    private Button searchLastMatches;
    private Button searchH2HMatches;

    ListMatches matches;
    String matchId;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        searchLastMatches = findViewById(R.id.search_last_matched);
        searchLastMatches.setOnClickListener(this);

        searchH2HMatches = findViewById(R.id.search_last_h2h_matches);
        searchH2HMatches.setOnClickListener(this);

    }

    @Override
    public ListMatches processFinish(String output) {
        Log.d(TAG, "processFinish: " + output);

        JsonParser jsonParser = new JsonParser();
        matches = null;
        try {
            matches = jsonParser.gsonParser(output);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return matches;
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

        GetData getData = new GetData(this);
        UrlBuilder urlBuilder = new UrlBuilder();

        URL urlH2HMatches;
        URL urlHomeTEam;

        switch (view.getId()) {
            case R.id.search_last_h2h_matches:
                urlH2HMatches = urlBuilder.builderUrlH2HMatches(matchId);

                processFinish(getData.execute(urlH2HMatches).toString());
                setView(R.id.recycler_view, matches);
                break;

            case R.id.search_last_matched:
                urlHomeTEam = urlBuilder.builderUrlMatchesHomeTeam("65", "2021");
                getData.execute(urlHomeTEam);
                setView(R.id.recycler_view1, matches);
                break;
        }
    }
}
