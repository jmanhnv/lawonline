package com.law.lawonline.service;

import com.law.lawonline.common.Constants;
import com.law.lawonline.dao.FileDao;
import com.law.lawonline.helper.RestApi;
import com.law.lawonline.model.Result;
import com.law.lawonline.model.SearchInput;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service("searchService")
public class SearchService implements Constants {
    @Autowired
    private FileDao fileDao;

    public List<Result> search(final String text) {
        fileDao.save();

        SearchInput input = new SearchInput();
        input.setInputText(StringUtils.trimToEmpty(text));
        input.setIndexFrom(0);
        input.setIndexTo(10);

        List<Result> results = RestApi.search(input);
//        //TODO - dummy data
//        List<File> files = listFiles();
//        for (int i = 0; i < files.size(); i++) {
//            File f = files.get(i);
//            int x = i + 1;
//            results.add(new Result(String.valueOf(x), FilenameUtils.getBaseName(f.getName()),
//                    Lists.newArrayList("A" + x, "B" + x, "C" + x), f.getAbsolutePath(), Float.valueOf(x)));
//        }

        return results;
    }

    private List<File> listFiles() {
        try {
            File dir = new File(USER_HOME + FILE_SEPARATOR + "data");
            String[] extensions = new String[]{"pdf", "PDF"};
            LoggerFactory.getLogger(SearchService.class).info("Getting only .pdf files in " + dir.getCanonicalPath()
                    + " including those in subdirectories");
            return (List<File>) FileUtils.listFiles(dir, extensions, true);
        } catch (IOException e) {
            LoggerFactory.getLogger(SearchService.class).error("listFiles has error: ", e.getCause());
            return Collections.EMPTY_LIST;
        }
    }
}
