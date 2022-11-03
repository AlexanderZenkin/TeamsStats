package com.example.teamsstats.model;

public class ListMatches {

    public Matches[] listMatches;

    public ListMatches(int size) {
        listMatches = new Matches[size];
    }

    public void addMatch(String homeTeam, String awayTeam, String result, String matchId, int id) {
        Matches list = new Matches(homeTeam, awayTeam, result, matchId);
        listMatches[id] = list;
    }
}
