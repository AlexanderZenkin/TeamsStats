package com.example.teamsstats.model.dto.full_model;

import com.example.teamsstats.model.dto.base_model.BaseModelAggregates;
import com.example.teamsstats.model.dto.base_model.BaseModelFilters;
import com.example.teamsstats.model.dto.base_model.BaseModelResultSet;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class FullModelH2HMatches {

    @JsonProperty("filters")
    BaseModelFilters filters;

    @JsonProperty("resultSet")
    BaseModelResultSet resultSet;

    @JsonProperty("aggregates")
    BaseModelAggregates aggregates;

    @JsonProperty("matches")
    List<LinkedHashMap> matches;
}
