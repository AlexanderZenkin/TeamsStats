package com.example.teamsstats;

import com.example.teamsstats.model.ListMatches;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {

    public ListMatches gsonParser(String output) throws JSONException {

        JSONObject resultJson = new JSONObject(output);
        JSONArray matches = resultJson.getJSONArray("matches");

        String idCompetition = null;

        if(resultJson.has("competition"))
            idCompetition = resultJson.getJSONObject("competition").getString("id");

        ListMatches matchList = new ListMatches(matches.length());

        for (int i = 0; i < matches.length(); i++) {

            String matchId = matches.getJSONObject(i).getString("id");

            JSONObject objH = matches.getJSONObject(i).getJSONObject("homeTeam");
            String homeTeamName = objH.getString("shortName");

            JSONObject objHomeTeamId = matches.getJSONObject(i).getJSONObject("homeTeam");
            String idHomeTeam = objHomeTeamId.getString("id");

            JSONObject objHResult = matches.getJSONObject(i).getJSONObject("score");
            JSONObject homeTeamResults = objHResult.getJSONObject("fullTime");
            String homeTeamResult = homeTeamResults.getString("home");
            if (homeTeamResult.equals("null")) {
                homeTeamResult = "-";
            }

            JSONObject objA = matches.getJSONObject(i).getJSONObject("awayTeam");
            String awayTeamName = objA.getString("shortName");

            JSONObject objAwayTeamId = matches.getJSONObject(i).getJSONObject("awayTeam");
            String idAwayTeam = objAwayTeamId.getString("id");

            JSONObject objAResult = matches.getJSONObject(i).getJSONObject("score");
            JSONObject awayTeamResults = objAResult.getJSONObject("fullTime");
            String awayTeamResult = awayTeamResults.getString("away");
            if (awayTeamResult.equals("null")) {
                awayTeamResult = "-";
            }

            matchList.addMatch(homeTeamName, awayTeamName, homeTeamResult + ":" + awayTeamResult, matchId,
                    idHomeTeam, idAwayTeam, idCompetition, i);
        }
        return matchList;
    }
}
