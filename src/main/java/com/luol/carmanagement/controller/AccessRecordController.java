package com.luol.carmanagement.controller;


import com.luol.carmanagement.common.Result;
import com.luol.carmanagement.entity.AccessRecord;
import com.luol.carmanagement.annotation.ActionLog;
import com.luol.carmanagement.service.AccessRecordService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 出入记录
 * @author luolei
 */
@RestController
@RequestMapping("/accessRecord")
public class AccessRecordController {

    @Resource
    public AccessRecordService accessRecordService;

    @RequestMapping(method = RequestMethod.GET,path = "/get")
    public Result getAccessRecordList(){

        return Result.ok();
    }

    /**
     * 添加车辆出入记录
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,path = "/save")
    @ActionLog(description = "添加车辆出入记录")
    public Result saveAccessRecord(@RequestParam("carNo") String carNo){
        AccessRecord accessRecord = new AccessRecord();
        accessRecord.setAreaCarNo(carNo);
        accessRecordService.addAccessRecord(accessRecord);
        return Result.ok();
    }

}
