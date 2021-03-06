package com.law.lawonline.model;

import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private String id;
    private String content;
    private List<String> highLight;
    private String filePath;
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

    public String getContent() {
        return this.highLight.stream().map(Object::toString).collect(Collectors.joining("<br>"));
    }
}
