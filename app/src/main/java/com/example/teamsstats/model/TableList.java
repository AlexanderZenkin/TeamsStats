package com.example.teamsstats.model;

public class TableList {

    public Table[] tableList;

    public TableList(int size) {
        tableList = new Table[size];
    }

    public void addMatch(String teamPosition, String teamName, String playedGames, String teamForm,
                         String teamWon, String teamDraw, String teamLost, String teamGoalsFor, String teamGoalsAgainst, int id) {
        Table list = new Table(teamPosition, teamName, playedGames, teamForm, teamWon, teamDraw, teamLost, teamGoalsFor, teamGoalsAgainst);
        tableList[id] = list;
    }
}
