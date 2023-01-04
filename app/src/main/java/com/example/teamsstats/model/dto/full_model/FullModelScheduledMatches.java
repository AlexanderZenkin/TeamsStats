package com.example.teamsstats.model.dto.full_model;

import com.example.teamsstats.model.dto.base_model.BaseModelCompetition;
import com.example.teamsstats.model.dto.base_model.BaseModelFilters;
import com.example.teamsstats.model.dto.base_model.BaseModelMatches;
import com.example.teamsstats.model.dto.base_model.BaseModelResultSet;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.ToString;

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class FullModelScheduledMatches {

    @JsonProperty("filters")
    private BaseModelFilters filters;

    @JsonProperty("resultSet")
    private BaseModelResultSet resultSet;

    @JsonProperty("competition")
    private BaseModelCompetition competition;

    @JsonProperty("matches")
    private List<BaseModelMatches> matches;

    public BaseModelFilters getFilters() {
        return filters;
    }

    public BaseModelResultSet getResultSet() {
        return resultSet;
    }

    public BaseModelCompetition getCompetition() {
        return competition;
    }

    public List<BaseModelMatches> getMatches() {
        return matches;
    }
}
