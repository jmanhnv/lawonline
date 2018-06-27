package com.law.lawonline.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;
import java.util.stream.Collectors;

@JsonRootName(value = "result")
public class Result {
    @JsonProperty
    private String id;

    @JsonProperty
    private String fileName;

    @JsonProperty
    private List<String> highLight;

    @JsonProperty
    private String filePath;

    @JsonProperty
    private Float score;

    public Result() {
    }

    public Result(String id, String fileName, List<String> highLight, String filePath, Float score) {
        this.id = id;
        this.fileName = fileName;
        this.highLight = highLight;
        this.filePath = filePath;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
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

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public String getContent() {
        return this.highLight.stream().map(Object::toString).collect(Collectors.joining("<br>"));
    }
}
