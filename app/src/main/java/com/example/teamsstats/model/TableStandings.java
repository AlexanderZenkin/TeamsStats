package com.example.teamsstats.model;

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
public class TableStandings {


    @JsonProperty("area")
    LinkedHashMap area;

    @JsonProperty("competition")
    LinkedHashMap competition;

    @JsonProperty("filters")
    LinkedHashMap filters;

    @JsonProperty("standings")
    List<LinkedHashMap> standings;
    }
