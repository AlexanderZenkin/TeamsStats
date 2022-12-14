package com.example.teamsstats.model;

public class Table {

    String teamName;
    String teamPosition;
    String playedGames;
    String teamForm;
    String teamWon;
    String teamDraw;
    String teamLost;
    String teamGoalsFor;
    String teamGoalsAgainst;

    public Table(String teamName, String teamPosition, String playedGames, String teamForm,
                 String teamWon, String teamDraw, String teamLost, String teamGoalsFor, String teamGoalsAgainst) {
        this.teamName = teamName;
        this.teamPosition = teamPosition;
        this.playedGames = playedGames;
        this.teamForm = teamForm;
        this.teamWon = teamWon;
        this.teamDraw = teamDraw;
        this.teamLost = teamLost;
        this.teamGoalsFor = teamGoalsFor;
        this.teamGoalsAgainst = teamGoalsAgainst;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamPosition() {
        return teamPosition;
    }

    public String getPlayedGames() {
        return playedGames;
    }

    public String getTeamForm() {
        return teamForm;
    }

    public String getTeamWon() {
        return teamWon;
    }

    public String getTeamDraw() {
        return teamDraw;
    }

    public String getTeamLost() {
        return teamLost;
    }

    public String getTeamGoalsFor() {
        return teamGoalsFor;
    }

    public String getTeamGoalsAgainst() {
        return teamGoalsAgainst;
    }
}
