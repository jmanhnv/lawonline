package com.law.lawonline.elasticsearch.repository;

import com.law.lawonline.elasticsearch.model.Judgment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudgmentRepository extends JpaRepository<Judgment, Long> {
}