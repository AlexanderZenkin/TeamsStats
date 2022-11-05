package com.example.teamsstats.model;

public class TableList {

    public Table[] tableList;

    public TableList(int size) {
        tableList = new Table[size];
    }

    public void addMatch(String teamPosition, String teamName, String playedGames, int id) {
        Table list = new Table(teamPosition, teamName, playedGames);
        tableList[id] = list;
    }
}
