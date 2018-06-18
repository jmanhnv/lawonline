package com.law.lawonline.elasticsearch.service;

import com.law.lawonline.elasticsearch.model.Judgment;
import com.law.lawonline.elasticsearch.model.ResultContainer;
import com.law.lawonline.elasticsearch.model.SearchInput;

public interface JudgmentService {
    void reindexDB();

    Judgment addRecord(Judgment judgment);

    ResultContainer search(SearchInput searchInput);
}
