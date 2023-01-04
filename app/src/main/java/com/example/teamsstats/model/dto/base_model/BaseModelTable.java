package com.example.teamsstats.model.dto.base_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseModelTable {

    @JsonProperty("position")
    Integer position;

    @JsonProperty("team")
    BaseModelTeam team;

    @JsonProperty("playedGames")
    Integer playedGames;

    @JsonProperty("form")
    String form;

    @JsonProperty("won")
    String won;

    @JsonProperty("draw")
    String draw;

    @JsonProperty("lost")
    String lost;

    @JsonProperty("points")
    String points;

    @JsonProperty("goalsFor")
    String goalsFor;

    @JsonProperty("goalsAgainst")
    String goalsAgainst;

    @JsonProperty("goalDifference")
    String goalDifference;

    public Integer getPosition() {
        return position;
    }

    public BaseModelTeam getTeam() {
        return team;
    }

    public Integer getPlayedGames() {
        return playedGames;
    }

    public String getForm() {
        return form;
    }

    public String getWon() {
        return won;
    }

    public String getDraw() {
        return draw;
    }

    public String getLost() {
        return lost;
    }

    public String getPoints() {
        return points;
    }

    public String getGoalsFor() {
        return goalsFor;
    }

    public String getGoalsAgainst() {
        return goalsAgainst;
    }

    public String getGoalDifference() {
        return goalDifference;
    }

    @Override
    public String toString() {
        return "BaseModelTable{" +
                "position=" + position +
                ", team=" + team +
                ", playedGames=" + playedGames +
                ", form='" + form + '\'' +
                ", won='" + won + '\'' +
                ", draw='" + draw + '\'' +
                ", lost='" + lost + '\'' +
                ", points='" + points + '\'' +
                ", goalsFor='" + goalsFor + '\'' +
                ", goalsAgainst='" + goalsAgainst + '\'' +
                ", goalDifference='" + goalDifference + '\'' +
                '}';
    }
}
