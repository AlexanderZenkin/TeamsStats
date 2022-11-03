package com.example.teamsstats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamsstats.interfaces.AsyncResponse;
import com.example.teamsstats.interfaces.ListItemClickListener;
import com.example.teamsstats.model.ListMatches;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class ViewActivity extends Activity implements AsyncResponse, ListItemClickListener {

    private static final String TAG = "ViewActivity";

    private ListMatches matchList;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Intent intent = getIntent();
        String matchId = intent.getStringExtra("matchId");

        UrlBuilder urlBuilder = new UrlBuilder();
        URL url = urlBuilder.builderUrlH2HMatches(matchId);
        new GetData(this).execute(url);

    }

    @Override
    public void processFinish(String output) {
        Log.d(TAG, "processFinish: " + output);

        try {

            JSONObject resultJson = new JSONObject(output);
            JSONArray matches = resultJson.getJSONArray("matches");

            matchList = new ListMatches(matches.length());

            for (int i = 0; i < matches.length(); i++) {

                JSONObject objH = matches.getJSONObject(i).getJSONObject("homeTeam");
                String homeTeamName = objH.getString("shortName");

                JSONObject objHResult = matches.getJSONObject(i).getJSONObject("score");
                JSONObject homeTeamResults = objHResult.getJSONObject("fullTime");
                String homeTeamResult = homeTeamResults.getString("home");

                JSONObject objA = matches.getJSONObject(i).getJSONObject("awayTeam");
                String awayTeamName = objA.getString("shortName");

                JSONObject objAResult = matches.getJSONObject(i).getJSONObject("score");
                JSONObject awayTeamResults = objAResult.getJSONObject("fullTime");
                String awayTeamResult = awayTeamResults.getString("away");

                matchList.addMatch(homeTeamName, awayTeamName, homeTeamResult + ":" + awayTeamResult, null, i);
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
    public void onListItemClick(int clickItemIndex) {

    }
}
