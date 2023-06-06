package com.luol.carmanagement.controller;


import cn.hutool.core.date.DateUtil;
import com.luol.carmanagement.annotation.ActionLog;
import com.luol.carmanagement.common.Result;
import com.luol.carmanagement.entity.Area;
import com.luol.carmanagement.service.AreaService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 ** 区域管理
 * @author luolei
 */
@RestController
@RequestMapping("/area")
public class AreaController {

    @Resource
    private AreaService areaService;

    /**
     * 分页查询区域
     * @return
     */
    @RequestMapping("/getAreaList")
    @ActionLog(description = "分页查询区域")
    public Result getAreaList(@RequestBody Map<String,Object> map){
        Integer pageNum = (Integer) map.get("pageNum");
        Integer size = (Integer) map.get("size");
        return Result.ok(areaService.getAreaList(pageNum,size));
    }


    /**
     * 添加区域
     * @return
     */
    @RequestMapping("/saveArea")
    @ActionLog(description = "添加区域")
    public Result saveArea(@RequestBody Map<String,Object> map){
        Integer id = Integer.valueOf(String.valueOf(map.get("id")));
        String areaName = (String) map.get("areaName");
        Integer areaType = Integer.valueOf(String.valueOf(map.get("areaType")));
        String areaAddress = (String) map.get("areaAddress");
        Integer areaParkingNum =Integer.valueOf(String.valueOf(map.get("areaParkingNum")));
        Area area = new Area();
        if (id != 0) {
            area.setId(Long.valueOf(id));
        }
        area.setAreaAddress(areaAddress);
        area.setAreaName(areaName);
        area.setAreaParkingNum(areaParkingNum);
        area.setAreaType(areaType);
        area.setCreateTime(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        return Result.ok(areaService.saveArea(area));
    }


    /**
     * 修改区域信息
     * @return
     */
    @RequestMapping("/editArea")
    @ActionLog(description = "修改区域")
    public Result editArea(@RequestBody Map<String,Object> map){
        Integer id = Integer.valueOf(String.valueOf(map.get("id")));
        String areaName = (String) map.get("areaName");
        Integer areaType = Integer.valueOf(String.valueOf(map.get("areaType")));
        String areaAddress = (String) map.get("areaAddress");
        Integer areaParkingNum =Integer.valueOf(String.valueOf(map.get("areaParkingNum")));
        Area area = new Area();
        area.setId(Long.valueOf(id));
        area.setAreaAddress(areaAddress);
        area.setAreaName(areaName);
        area.setAreaParkingNum(areaParkingNum);
        area.setAreaType(areaType);
        area.setCreateTime(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        return Result.ok(areaService.editArea(area));
    }


    /**
     * 删除
     * @return
     */
    @RequestMapping(value = "/delArea/{id}",method = RequestMethod.DELETE)
    @ActionLog(description = "删除区域")
    public Result delArea(@PathVariable("id") Integer id){
        areaService.delArea(id);
        return Result.ok();
    }


}
