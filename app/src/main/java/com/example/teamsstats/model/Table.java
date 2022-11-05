package com.example.teamsstats.model;

public class Table {

    String teamName;
    String teamPosition;
    String playedGames;

    public Table(String teamName, String teamPosition, String playedGames) {
        this.teamName = teamName;
        this.teamPosition = teamPosition;
        this.playedGames = playedGames;
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
}
