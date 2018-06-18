package com.law.lawonline.service;

import com.law.lawonline.dao.FileDao;
import com.law.lawonline.model.ResultSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("searchService")
public class SearchService {
    @Autowired
    private FileDao fileDao;

    public ResultSearch[] search(final String text) {
        //TODO test only
        fileDao.save();
        ResultSearch[] resultSearches = new ResultSearch[3];
        for (int i = 0; i < 3; i++) {
            ResultSearch rs = new ResultSearch(1, "aaaa", "ddd", 50.0);
            resultSearches[i] = rs;
        }

        return resultSearches;
    }
}
