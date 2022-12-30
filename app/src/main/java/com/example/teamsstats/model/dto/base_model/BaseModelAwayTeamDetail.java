package com.example.teamsstats.model.dto.base_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseModelAwayTeamDetail {

    @JsonProperty("id")
    Integer id;

    @JsonProperty("name")
    String name;

    @JsonProperty("shortName")
    String shortName;

    @JsonProperty("tla")
    String tla;

    @JsonProperty("crest")
    String crest;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getTla() {
        return tla;
    }

    public String getCrest() {
        return crest;
    }
}
