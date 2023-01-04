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
public class BaseModelHomeTeam {

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
        return "BaseModelHomeTeam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wins=" + wins +
                ", draws=" + draws +
                ", losses=" + losses +
                '}';
    }
}
