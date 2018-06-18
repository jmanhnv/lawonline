package com.law.lawonline.elasticsearch.controller;

import com.law.lawonline.elasticsearch.model.Judgment;
import com.law.lawonline.elasticsearch.model.ResultContainer;
import com.law.lawonline.elasticsearch.model.SearchInput;
import com.law.lawonline.elasticsearch.service.JudgmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class SearchCtrl {

    @Autowired
    JudgmentService judgmentService;

    // add document
    @PostMapping("/add")
    public String createDocument(@Valid @RequestBody Judgment judgment) {
        Judgment judg = judgmentService.addRecord(judgment);
        if (judg.getId() != null) {
            return "OK";
        }
        return "FAIL";
    }

    @PostMapping("/search")
    public ResultContainer search(@Valid @RequestBody SearchInput searchInput) {
        return judgmentService.search(searchInput);
    }
}
