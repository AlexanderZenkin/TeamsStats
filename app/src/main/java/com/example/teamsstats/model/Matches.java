package com.example.teamsstats.model;

public class Matches {

    int id;
    String homeTeam;
    String awayTeam;
    String result;
    String matchId;
    String idHomeTeam;
    String idAwayTeam;
    String idCompetition;

    public Matches(String homeTeam, String awayTeam, String result, String matchId,
                   String idHomeTeam, String idAwayTeam, String idCompetition) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.result = result;
        this.matchId = matchId;
        this.idHomeTeam = idHomeTeam;
        this.idAwayTeam = idAwayTeam;
        this.idCompetition = idCompetition;
    }

    public int getId() {
        return id;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getResult() {
        return result;
    }

    public String getMatchId() {
        return matchId;
    }

    public String getIdHomeTeam() {
        return idHomeTeam;
    }

    public String getIdAwayTeam() {
        return idAwayTeam;
    }

    public String getIdCompetition() {
        return idCompetition;
    }
}
