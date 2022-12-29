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
public class BaseModelResultSet {

    @JsonProperty("count")
    Integer count;

    @JsonProperty("competitions")
    String competitions;

    @JsonProperty("first")
    String first;

    @JsonProperty("last")
    String last;
}
