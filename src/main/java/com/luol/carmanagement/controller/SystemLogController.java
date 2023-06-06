package com.luol.carmanagement.controller;


import com.luol.carmanagement.annotation.ActionLog;
import com.luol.carmanagement.common.Result;
import com.luol.carmanagement.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 ** 日志
 * @author luolei
 */
@RestController
@RequestMapping("/log")
public class SystemLogController {


    @Autowired
    private SystemLogService systemLogService;


    /**
     * 分页查询日志
     * @return
     */
    @RequestMapping("/getSystemLog")
    @ActionLog(description = "分页查询日志")
    public Result getSystemLog(@RequestBody Map<String,Object> map){
        Integer pageNum = (Integer) map.get("pageNum");
        Integer size = (Integer) map.get("size");

        return Result.ok(systemLogService.getSystemLog(pageNum,size));
    }

}
