package com.law.lawonline.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResultContainer {
    @JsonProperty
    private List<Result> result;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }
}
