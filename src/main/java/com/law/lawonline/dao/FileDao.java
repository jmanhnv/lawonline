package com.law.lawonline.dao;

import com.law.lawonline.model.Judgment;

public interface FileDao {//extends JpaRepository<ResultSearch, Long>

    void save();

    Judgment getJudgmentById(int id);
}
