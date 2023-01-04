package com.example.teamsstats.model.dto.base_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseModelMatches {

    @JsonProperty("area")
    BaseModelArea area;

    @JsonProperty("competition")
    BaseModelCompetition competition;

    @JsonProperty("season")
    BaseModelSeason season;

    @JsonProperty("id")
    Integer id;

    @JsonProperty("utcDate")
    String utcDate;

    @JsonProperty("status")
    String status;

    @JsonProperty("matchday")
    Integer matchday;

    @JsonProperty("stage")
    String stage;

    @JsonProperty("group")
    Object group;

    @JsonProperty("lastUpdated")
    String lastUpdated;

    @JsonProperty("homeTeam")
    BaseModelHomeTeamDetail homeTeam;

    @JsonProperty("awayTeam")
    BaseModelAwayTeamDetail awayTeam;

    @JsonProperty("score")
    BaseModelScore score;

    @JsonProperty("odds")
    BaseModelOdds odds;

    @JsonProperty("referees")
    List<BaseModelReferees> referees;

    public BaseModelArea getArea() {
        return area;
    }

    public BaseModelCompetition getCompetition() {
        return competition;
    }

    public BaseModelSeason getSeason() {
        return season;
    }

    public String getUtcDate() {
        return utcDate;
    }

    public String getStatus() {
        return status;
    }

    public Integer getMatchday() {
        return matchday;
    }

    public String getStage() {
        return stage;
    }

    public Object getGroup() {
        return group;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public BaseModelHomeTeamDetail getHomeTeam() {
        return homeTeam;
    }

    public BaseModelAwayTeamDetail getAwayTeam() {
        return awayTeam;
    }

    public BaseModelScore getScore() {
        return score;
    }

    public BaseModelOdds getOdds() {
        return odds;
    }

    public List<BaseModelReferees> getReferees() {
        return referees;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BaseModelMatches{" +
                "area=" + area +
                ", competition=" + competition +
                ", season=" + season +
                ", id=" + id +
                ", utcDate='" + utcDate + '\'' +
                ", status='" + status + '\'' +
                ", matchday=" + matchday +
                ", stage='" + stage + '\'' +
                ", group=" + group +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", score=" + score +
                ", odds=" + odds +
                ", referees=" + referees +
                '}';
    }
}
