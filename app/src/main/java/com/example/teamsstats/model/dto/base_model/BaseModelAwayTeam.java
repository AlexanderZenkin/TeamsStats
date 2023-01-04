package com.example.teamsstats.model.dto.base_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseModelAwayTeam {

    @JsonProperty("id")
    Integer id;

    @JsonProperty("name")
    String name;

    @JsonProperty("wins")
    Integer wins;

    @JsonProperty("draws")
    Integer draws;

    @JsonProperty("losses")
    Integer losses;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getWins() {
        return wins;
    }

    public Integer getDraws() {
        return draws;
    }

    public Integer getLosses() {
        return losses;
    }

    @Override
    public String toString() {
        return "BaseModelAwayTeam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wins=" + wins +
                ", draws=" + draws +
                ", losses=" + losses +
                '}';
    }
}
