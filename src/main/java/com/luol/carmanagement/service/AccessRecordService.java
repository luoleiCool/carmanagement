package com.luol.carmanagement.service;


import com.luol.carmanagement.entity.AccessRecord;
import com.luol.carmanagement.entity.Area;
import org.springframework.data.domain.Page;
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


    /**
     * 分页查询
     * @param pageNum
     * @param size
     * @return
     */
    Page<AccessRecord> getAccessRecordList(Integer pageNum, Integer size);

}
