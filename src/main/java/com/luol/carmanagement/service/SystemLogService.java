package com.luol.carmanagement.service;

import com.luol.carmanagement.entity.SystemLog;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SystemLogService {

    Page<SystemLog> getSystemLog(Integer pageNum, Integer size);

}
