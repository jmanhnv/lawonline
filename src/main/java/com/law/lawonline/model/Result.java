package com.law.lawonline.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName(value = "result")
public class Result {
    @JsonProperty
    private String id;

    @JsonProperty
    private List<String> highLight;

    @JsonProperty
    private String filePath;

    @JsonProperty
    private Float score;

    public String getId() {
        return id;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getHighLight() {
        return highLight;
    }

    public void setHighLight(List<String> highLight) {
        this.highLight = highLight;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
