package com.law.lawonline.elasticsearch.repository;

import com.law.lawonline.elasticsearch.model.JudgmentEs;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JudgmentEsRepository extends ElasticsearchRepository<JudgmentEs, String> {
    List<JudgmentEs> findByFileNameOrContent(String fileName, String content, Pageable pageable);
}