package com.luol.carmanagement.controller;


import com.luol.carmanagement.common.Result;
import com.luol.carmanagement.entity.AccessRecord;
import com.luol.carmanagement.annotation.ActionLog;
import com.luol.carmanagement.service.AccessRecordService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 出入记录
 * @author luolei
 */
@RestController
@RequestMapping("/accessRecord")
public class AccessRecordController {

    @Resource
    public AccessRecordService accessRecordService;


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


    /**
     * 分页查询区域
     * @return
     */
    @RequestMapping("/getAccessRecordList")
    @ActionLog(description = "分页查询出入记录")
    public Result getAccessRecordList(@RequestBody Map<String,Object> map){
        Integer pageNum = (Integer) map.get("pageNum");
        Integer size = (Integer) map.get("size");
        return Result.ok(accessRecordService.getAccessRecordList(pageNum,size));
    }

}
