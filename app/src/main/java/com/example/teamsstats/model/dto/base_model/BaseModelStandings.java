package com.example.teamsstats.model.dto.base_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseModelStandings {

    @JsonProperty("stage")
    String stage;

    @JsonProperty("type")
    String type;

    @JsonProperty("group")
    String group;

    @JsonProperty("table")
    List<BaseModelTable> table;

    public String getStage() {
        return stage;
    }

    public String getType() {
        return type;
    }

    public String getGroup() {
        return group;
    }

    public List<BaseModelTable> getTable() {
        return table;
    }
}
