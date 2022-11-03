package com.example.teamsstats.model;

public class Matches {

    int id;
    String homeTeam;
    String awayTeam;
    String result;
    String matchId;

    public Matches(String homeTeam, String awayTeam, String result, String matchId) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.result = result;
        this.matchId = matchId;
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
}
