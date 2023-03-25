package com.luol.carmanagement.repository;

import com.luol.carmanagement.entity.AccessRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author luolei
 */
@Repository
public interface AccessRecordRepository extends JpaRepository<AccessRecord, Integer> {

}
