package com.law.lawonline.helper;

import com.law.lawonline.model.Judgment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JudgmentMapper implements RowMapper<Judgment> {
    @Override
    public Judgment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Judgment judgment = new Judgment();
        judgment.setId(rs.getInt("id"));
        judgment.setFilePath(rs.getString("file_path"));
        judgment.setCategoryId(rs.getInt("category_id"));
        judgment.setUserId(rs.getInt("user_id"));
        judgment.setFileName(rs.getString("file_name"));
        judgment.setContent(rs.getBytes("content"));
        judgment.setCreatedDate(rs.getDate("created_date"));
        judgment.setUpdatedDate(rs.getDate("updated_date"));
        return judgment;
    }
}
