package com.example.teamsstats;

import com.example.teamsstats.model.ListMatches;
import com.example.teamsstats.model.TableList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser extends MainActivity {

    public ListMatches gsonParser(String output) throws JSONException {

        JSONObject resultJson = new JSONObject(output);
        JSONArray matches = resultJson.getJSONArray("matches");

        String idCompetition = null;

        if (resultJson.has("competition"))
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

    public TableList gsonParserTable(String output, int element) throws JSONException {

        JSONObject resultJson = new JSONObject(output);
        JSONArray table = resultJson.getJSONArray("standings").getJSONObject(element).getJSONArray("table");

        TableList tableList = new TableList(table.length());

        for (int i = 0; i < table.length(); i++) {

            String teamPosition = table.getJSONObject(i).getString("position");
            String homeTeamName = table.getJSONObject(i).getJSONObject("team").getString("shortName");
            String playedGames = table.getJSONObject(i).getString("playedGames");
            String teamForm = table.getJSONObject(i).getString("form");
            String teamWon = table.getJSONObject(i).getString("won");
            String teamDraw = table.getJSONObject(i).getString("draw");
            String teamLost = table.getJSONObject(i).getString("lost");
            String teamGoalsFor = table.getJSONObject(i).getString("goalsFor");
            String teamGoalsAgainst = table.getJSONObject(i).getString("goalsAgainst");

            tableList.addMatch(teamPosition, homeTeamName, playedGames, teamForm,
                    teamWon, teamDraw, teamLost, teamGoalsFor, teamGoalsAgainst, i);
        }
        return tableList;
    }
}
