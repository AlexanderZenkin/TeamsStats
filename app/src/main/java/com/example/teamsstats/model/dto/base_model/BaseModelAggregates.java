package com.example.teamsstats.model.dto.base_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseModelAggregates {

    @JsonProperty("numberOfMatches")
    Integer numberOfMatches;

    @JsonProperty("totalGoals")
    Integer totalGoals;

    @JsonProperty("homeTeam")
    BaseModelHomeTeam homeTeam;

    @JsonProperty("awayTeam")
    BaseModelAwayTeam awayTeam;

    public Integer getNumberOfMatches() {
        return numberOfMatches;
    }

    public Integer getTotalGoals() {
        return totalGoals;
    }

    public BaseModelHomeTeam getHomeTeam() {
        return homeTeam;
    }

    public BaseModelAwayTeam getAwayTeam() {
        return awayTeam;
    }

    @Override
    public String toString() {
        return "BaseModelAggregates{" +
                "numberOfMatches=" + numberOfMatches +
                ", totalGoals=" + totalGoals +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                '}';
    }
}
