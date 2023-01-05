package com.example.teamsstats.model;

import java.util.Arrays;

public class ListMatches {

    public Matches[] listMatches;

    public ListMatches(int size) {
        listMatches = new Matches[size];
    }

    public void addMatch(String homeTeam, String awayTeam, String result, String matchId, String idHomeTeam,
                         String idAwayTEam, String idCompetition, int id) {
        Matches list = new Matches(homeTeam, awayTeam, result, matchId, idHomeTeam, idAwayTEam, idCompetition);
        listMatches[id] = list;
    }

    @Override
    public String toString() {
        return "ListMatches{" +
                "listMatches=" + Arrays.toString(listMatches) +
                '}';
    }
}
