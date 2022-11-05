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
            String homeTeamName = matches.getJSONObject(i).getJSONObject("homeTeam").getString("shortName");
            String idHomeTeam = matches.getJSONObject(i).getJSONObject("homeTeam").getString("id");
            String homeTeamResult = matches.getJSONObject(i).getJSONObject("score").getJSONObject("fullTime").getString("home");
            if (homeTeamResult.equals("null")) {
                homeTeamResult = "-";
            }
            String awayTeamName = matches.getJSONObject(i).getJSONObject("awayTeam").getString("shortName");
            String idAwayTeam = matches.getJSONObject(i).getJSONObject("awayTeam").getString("id");
            String awayTeamResult = matches.getJSONObject(i).getJSONObject("score").getJSONObject("fullTime").getString("away");
            if (awayTeamResult.equals("null")) {
                awayTeamResult = "-";
            }

            matchList.addMatch(homeTeamName, awayTeamName, homeTeamResult + ":" + awayTeamResult, matchId,
                    idHomeTeam, idAwayTeam, idCompetition, i);
        }
        return matchList;
    }
}
