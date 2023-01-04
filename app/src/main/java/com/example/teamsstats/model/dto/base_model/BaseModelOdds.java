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
public class BaseModelOdds {

    @JsonProperty("msg")
    String msg;

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "BaseModelOdds{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
