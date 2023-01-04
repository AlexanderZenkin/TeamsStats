package com.example.teamsstats;

import com.example.teamsstats.model.ListMatches;
import com.example.teamsstats.model.TableList;
import com.example.teamsstats.model.dto.full_model.FullModelH2HMatches;
import com.example.teamsstats.model.dto.full_model.FullModelScheduledMatches;
import com.example.teamsstats.model.dto.full_model.FullModelTournamentTable;

public class JsonParser {

    public ListMatches inflateListMatches(FullModelH2HMatches fullModelH2HMatches) {
        ListMatches matchList = new ListMatches(fullModelH2HMatches.getMatches().size());

        for (int i = 0; i < fullModelH2HMatches.getMatches().size(); i++) {
            String homeTeamResult = fullModelH2HMatches.getMatches().get(i).getScore().getFullTime().getHome();
            String awayTeamResult = fullModelH2HMatches.getMatches().get(i).getScore().getFullTime().getAway();

            matchList.addMatch(fullModelH2HMatches.getMatches().get(i).getHomeTeam().getShortName(),
                    fullModelH2HMatches.getMatches().get(i).getAwayTeam().getShortName(),
                    homeTeamResult + ":" + awayTeamResult,
                    fullModelH2HMatches.getMatches().get(i).getId().toString(),
                    fullModelH2HMatches.getMatches().get(i).getHomeTeam().getId().toString(),
                    fullModelH2HMatches.getMatches().get(i).getAwayTeam().getId().toString(),
                    null, i);
        }
        return matchList;
    }

    public ListMatches inflateScheduledMatches(FullModelScheduledMatches fullModelScheduledMatches) {
        ListMatches matchList = new ListMatches(fullModelScheduledMatches.getMatches().size());
        String idCompetition = fullModelScheduledMatches.getCompetition().getId().toString();

        for (int i = 0; i < fullModelScheduledMatches.getMatches().size(); i++) {
            String homeTeamResult = fullModelScheduledMatches.getMatches().get(i).getScore().getFullTime().getHome();
            if (homeTeamResult == null) {
                homeTeamResult = "-";
            }
            String awayTeamResult = fullModelScheduledMatches.getMatches().get(i).getScore().getFullTime().getAway();
            if (awayTeamResult == null) {
                awayTeamResult = "-";
            }

            matchList.addMatch(fullModelScheduledMatches.getMatches().get(i).getHomeTeam().getShortName(),
                    fullModelScheduledMatches.getMatches().get(i).getAwayTeam().getShortName(),
                    homeTeamResult + ":" + awayTeamResult,
                    fullModelScheduledMatches.getMatches().get(i).getId().toString(),
                    fullModelScheduledMatches.getMatches().get(i).getHomeTeam().getId().toString(),
                    fullModelScheduledMatches.getMatches().get(i).getAwayTeam().getId().toString(),
                    idCompetition, i);
        }
        return matchList;
    }

    public TableList inflateTableList(FullModelTournamentTable fullModelTournamentTable, int element) {

        var table = fullModelTournamentTable.getStandings().get(element).getTable();
        TableList tableList = new TableList(table.size());

        for (int i = 0; i < fullModelTournamentTable.getStandings().get(element).getTable().size(); i++) {

            tableList.addMatch(table.get(i).getPosition().toString(), table.get(i).getTeam().getShortName(),
                    table.get(i).getPlayedGames().toString(), table.get(i).getForm(),
                    table.get(i).getWon(), table.get(i).getDraw(), table.get(i).getLost(),
                    table.get(i).getGoalsFor(), table.get(i).getGoalsAgainst(), i);
        }
        return tableList;
    }
}
