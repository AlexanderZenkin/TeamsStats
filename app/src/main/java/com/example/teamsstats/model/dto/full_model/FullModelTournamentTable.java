package com.example.teamsstats.model.dto.full_model;

import com.example.teamsstats.model.dto.base_model.BaseModelArea;
import com.example.teamsstats.model.dto.base_model.BaseModelCompetition;
import com.example.teamsstats.model.dto.base_model.BaseModelFilters;
import com.example.teamsstats.model.dto.base_model.BaseModelSeason;
import com.example.teamsstats.model.dto.base_model.BaseModelStandings;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.ToString;

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class FullModelTournamentTable {

    @JsonProperty("filters")
    private BaseModelFilters filters;

    @JsonProperty("area")
    private BaseModelArea area;

    @JsonProperty("competition")
    private BaseModelCompetition competition;

    @JsonProperty("season")
    private BaseModelSeason season;

    @JsonProperty("standings")
    private List<BaseModelStandings> standings;

    public BaseModelFilters getFilters() {
        return filters;
    }

    public BaseModelArea getArea() {
        return area;
    }

    public BaseModelCompetition getCompetition() {
        return competition;
    }

    public BaseModelSeason getSeason() {
        return season;
    }

    public List<BaseModelStandings> getStandings() {
        return standings;
    }
}
