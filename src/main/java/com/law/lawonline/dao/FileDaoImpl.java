package com.law.lawonline.dao;

import org.springframework.stereotype.Repository;

@Repository("fileDao")
public class FileDaoImpl implements FileDao {
    @Override
    public void save() {
        //TODO test only
        System.out.printf("save success....");
    }
}
