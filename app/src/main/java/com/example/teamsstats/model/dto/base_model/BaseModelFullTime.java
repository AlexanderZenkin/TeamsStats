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
public class BaseModelFullTime {

    @JsonProperty("home")
    String home;

    @JsonProperty("away")
    String away;

    public String getHome() {
        return home;
    }

    public String getAway() {
        return away;
    }
}
