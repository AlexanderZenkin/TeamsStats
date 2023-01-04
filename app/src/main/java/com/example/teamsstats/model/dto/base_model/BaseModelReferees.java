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
public class BaseModelReferees {

    @JsonProperty("id")
    Integer id;

    @JsonProperty("name")
    String name;

    @JsonProperty("type")
    String type;

    @JsonProperty("nationality")
    String nationality;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return "BaseModelReferees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
