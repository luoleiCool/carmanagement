package com.luol.carmanagement.controller;


import cn.hutool.core.date.DateUtil;
import com.luol.carmanagement.annotation.ActionLog;
import com.luol.carmanagement.common.Result;
import com.luol.carmanagement.entity.Area;
import com.luol.carmanagement.entity.AreaUser;
import com.luol.carmanagement.service.AreaService;
import com.luol.carmanagement.service.AreaUserService;
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
@RequestMapping("/areaUser")
public class AreaUserController {

    @Resource
    private AreaUserService areaUserService;

    /**
     * 分页查询区域
     * @return
     */
    @RequestMapping("/getAreaUserList")
    @ActionLog(description = "分页查询区域用户")
    public Result getAreaUserList(@RequestBody Map<String,Object> map){
        Integer pageNum = (Integer) map.get("pageNum");
        Integer size = (Integer) map.get("size");
        return Result.ok(areaUserService.getAreaUserList(pageNum,size));
    }


    /**
     * 添加区域
     * @return
     */
    @RequestMapping("/saveAreaUser")
    @ActionLog(description = "添加区域用户")
    public Result saveAreaUser(@RequestBody Map<String,Object> map){
        Integer id = Integer.valueOf(String.valueOf(map.get("id")));
        String userName = (String) map.get("userName");
        Integer areaId = Integer.valueOf(String.valueOf(map.get("areaId")));
        String tel = (String) map.get("tel");
        String carNo = (String) map.get("carNo");

        AreaUser areaUser = new AreaUser();
        if (id != 0) {
            areaUser.setId(Long.valueOf(id));
        }
        areaUser.setUserName(userName);
        areaUser.setTel(tel);
        areaUser.setCarNo(carNo);
        areaUser.setAreaId(areaId);
        areaUser.setCreateTime(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        return Result.ok(areaUserService.saveAreaUser(areaUser));
    }


    /**
     * 修改区域信息
     * @return
     */
    @RequestMapping("/editAreaUser")
    @ActionLog(description = "修改区域用户")
    public Result editAreaUser(@RequestBody Map<String,Object> map){
        Integer id = Integer.valueOf(String.valueOf(map.get("id")));
        String userName = (String) map.get("userName");
        Integer areaId = Integer.valueOf(String.valueOf(map.get("areaId")));
        String tel = (String) map.get("tel");
        String carNo = (String) map.get("carNo");

        AreaUser areaUser = new AreaUser();
        if (id != 0) {
            areaUser.setId(Long.valueOf(id));
        }
        areaUser.setUserName(userName);
        areaUser.setTel(tel);
        areaUser.setCarNo(carNo);
        areaUser.setAreaId(areaId);
        areaUser.setCreateTime(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        return Result.ok(areaUserService.editAreaUser(areaUser));
    }


    /**
     * 删除
     * @return
     */
    @RequestMapping(value = "/delAreaUser/{id}",method = RequestMethod.DELETE)
    @ActionLog(description = "删除区域用户")
    public Result delArea(@PathVariable("id") Integer id){
        areaUserService.delAreaUser(id);
        return Result.ok();
    }


}
