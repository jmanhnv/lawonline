package com.law.lawonline.service;

import com.law.lawonline.dao.FileDao;
import com.law.lawonline.helper.RestApi;
import com.law.lawonline.model.Result;
import com.law.lawonline.model.SearchInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("searchService")
public class SearchService {
    @Autowired
    private FileDao fileDao;

    public List<Result> search(final String text) {
        fileDao.save();

        SearchInput input = new SearchInput();
        input.setInputText(text);
        input.setIndexFrom(0);
        input.setIndexTo(10);

        return RestApi.search(input);
    }
}
