package com.example.teamsstats.model.dto.base_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
}
