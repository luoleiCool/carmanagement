package com.luol.carmanagement.service;


import com.luol.carmanagement.entity.AccessRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * @author luolei
 */

public interface AccessRecordService{

    /**
     * 添加出入记录
     * @param accessRecord
     */
     void addAccessRecord(AccessRecord accessRecord);


}
