package com.luol.carmanagement.repository;

import com.luol.carmanagement.entity.AccessRecord;
import com.luol.carmanagement.entity.SystemLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *
 * @author luolei
 */
@Repository
public interface SystemLogRepository extends JpaRepository<SystemLog, Integer> {
}
