package com.law.lawonline.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class ResultSearch implements Serializable {
    private Integer id;
    private String highLight;
    private String filePath;
    private Double score;

    public ResultSearch() {
    }

    public ResultSearch(Integer id, String highLight, String filePath, Double score) {
        this.id = id;
        this.highLight = highLight;
        this.filePath = filePath;
        this.score = score;
    }
}
