package com.law.lawonline.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "searchQuery")
public class SearchInput {
    @JsonProperty
    private String inputText;

    @JsonProperty
    private Integer indexFrom;

    @JsonProperty
    private Integer indexTo;

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public Integer getIndexFrom() {
        return indexFrom;
    }

    public void setIndexFrom(Integer indexFrom) {
        this.indexFrom = indexFrom;
    }

    public Integer getIndexTo() {
        return indexTo;
    }

    public void setIndexTo(Integer indexTo) {
        this.indexTo = indexTo;
    }
}
