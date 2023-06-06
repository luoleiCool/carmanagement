package com.luol.carmanagement.service.impl;

import com.luol.carmanagement.entity.SystemLog;
import com.luol.carmanagement.repository.SystemLogRepository;
import com.luol.carmanagement.service.SystemLogService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Resource
    private SystemLogRepository systemLogRepository;

    @Override
    public Page<SystemLog> getSystemLog(Integer pageNum, Integer size) {
        PageRequest pageRequest = PageRequest.of(pageNum, size, Sort.by("createTime").descending());
        return systemLogRepository.findAll(pageRequest);
    }


}
