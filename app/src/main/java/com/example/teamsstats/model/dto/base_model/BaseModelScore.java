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
public class BaseModelScore {

    @JsonProperty("winner")
    String winner;

    @JsonProperty("duration")
    String duration;

    @JsonProperty("fullTime")
    BaseModelFullTime fullTime;

    @JsonProperty("halfTime")
    BaseModelHalfTime halfTime;

    public String getWinner() {
        return winner;
    }

    public String getDuration() {
        return duration;
    }

    public BaseModelFullTime getFullTime() {
        return fullTime;
    }

    public BaseModelHalfTime getHalfTime() {
        return halfTime;
    }
}
