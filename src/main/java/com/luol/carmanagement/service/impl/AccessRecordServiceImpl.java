package com.luol.carmanagement.service.impl;

import com.luol.carmanagement.entity.AccessRecord;
import com.luol.carmanagement.repository.AccessRecordRepository;
import com.luol.carmanagement.service.AccessRecordService;
import jakarta.annotation.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author luolei
 */
@Service
public class AccessRecordServiceImpl implements AccessRecordService {

    @Resource
    private AccessRecordRepository accessRecordRepository;

    @Override
    public void addAccessRecord(AccessRecord accessRecord) {
        // 判定是否为区域用户车辆 若否则为临时车辆  若是则关联对应信息

        accessRecordRepository.save(accessRecord);
    }
}
