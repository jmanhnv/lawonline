package com.law.lawonline.dao.impl;

import com.law.lawonline.dao.FileDao;
import com.law.lawonline.helper.JudgmentMapper;
import com.law.lawonline.model.Judgment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("fileDao")
@Component
public class FileDaoImpl implements FileDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @Autowired
//    public FileDaoImpl(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }

    private final String SQL_FIND_JUDGMENT = "select * from judgment where id = ?";

    @Override
    public void save() {
        //TODO test only
        System.out.printf("save success....");
    }

    @Override
    public Judgment getJudgmentById(int id) {
        return jdbcTemplate.queryForObject(SQL_FIND_JUDGMENT, new Object[]{id}, new JudgmentMapper());
    }
}
