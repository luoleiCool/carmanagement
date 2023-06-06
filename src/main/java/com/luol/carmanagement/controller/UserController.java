package com.luol.carmanagement.controller;

import cn.hutool.core.date.DateUtil;
import com.luol.carmanagement.annotation.ActionLog;
import com.luol.carmanagement.common.Result;
import com.luol.carmanagement.entity.AreaUser;
import com.luol.carmanagement.entity.SystemUser;
import com.luol.carmanagement.service.SystemUserService;
import com.luol.carmanagement.utils.TokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * 用户类
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SystemUserService systemUserService;

    /**
     * 根据token 加载用户信息
     */
    @RequestMapping("/loadUser")
    @ActionLog(description = "获取用户信息")
    public Result loadUserInfo(){
        String token = request.getHeader("token");
        // 解析token获取用户信息
        Integer userId = TokenUtils.getUserIdByToken(token);
        return Result.ok(systemUserService.getSystemUser(userId));
    }


    /**
     * 分页查询用户
     * @return
     */
    @RequestMapping("/getSystemUser")
    @ActionLog(description = "获取用户列表")
    public Result getSystemUser(@RequestBody Map<String,Object> map){
        Integer pageNum = (Integer) map.get("pageNum");
        Integer size = (Integer) map.get("size");
        return Result.ok(systemUserService.getSystemUser(pageNum,size));
    }

    /**
     * 添加区域
     * @return
     */
    @RequestMapping("/saveUser")
    @ActionLog(description = "添加用户")
    public Result saveUser(@RequestBody Map<String,Object> map){
        Integer id = Integer.valueOf(String.valueOf(map.get("id")));
        String userName = (String) map.get("userName");
        String password = (String) map.get("password");
        SystemUser systemUser = new SystemUser();
        if (id != 0) {
            systemUser.setId(Long.valueOf(id));
        }
        systemUser.setUserName(userName);
        systemUser.setPassword(password);
        systemUser.setCreateTime(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        return Result.ok(systemUserService.saveUser(systemUser));
    }


    /**
     * 修改区域信息
     * @return
     */
    @RequestMapping("/editUser")
    @ActionLog(description = "修改用户")
    public Result editAreaUser(@RequestBody Map<String,Object> map){
        Integer id = Integer.valueOf(String.valueOf(map.get("id")));
        String userName = (String) map.get("userName");
        String password = (String) map.get("password");
        SystemUser systemUser = new SystemUser();
        if (id != 0) {
            systemUser.setId(Long.valueOf(id));
        }
        systemUser.setUserName(userName);
        systemUser.setPassword(password);
        systemUser.setCreateTime(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        return Result.ok(systemUserService.saveUser(systemUser));
    }


    /**
     * 删除
     * @return
     */
    @RequestMapping(value = "/delUser/{id}",method = RequestMethod.DELETE)
    @ActionLog(description = "删除用户")
    public Result delArea(@PathVariable("id") Integer id){
        systemUserService.delUser(id);
        return Result.ok();
    }




}
