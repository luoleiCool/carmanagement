package com.luol.carmanagement.controller;


import com.luol.carmanagement.common.Result;
import com.luol.carmanagement.annotation.ActionLog;
import com.luol.carmanagement.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 ** 登录
 * @author luolei
 */
@RestController
public class LoginController {


    @Autowired
    private LoginService loginService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ActionLog(description = "登录")
    public Result login(@RequestBody Map<String,Object> map){
        String userName = "";
        String password = "";

        userName = String.valueOf(map.get("name"));
        password = String.valueOf(map.get("password"));

        // 登录验证
        return Result.ok(loginService.userLogin(userName,password));
    }

}
