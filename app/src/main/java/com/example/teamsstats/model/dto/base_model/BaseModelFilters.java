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
public class BaseModelFilters {

    @JsonProperty("limit")
    String limit;

    @JsonProperty("permission")
    String permission;

    public String getLimit() {
        return limit;
    }

    public String getPermission() {
        return permission;
    }

    @Override
    public String toString() {
        return "BaseModelFilters{" +
                "limit='" + limit + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}
