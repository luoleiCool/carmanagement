package com.luol.carmanagement.controller;


import com.luol.carmanagement.common.Result;
import com.luol.carmanagement.annotation.ActionLog;
import com.luol.carmanagement.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Result login(@RequestParam ("userName") String userName,@RequestParam ("password") String password){
        // 登录验证
        loginService.userLogin(userName,password);

        return Result.ok();
    }

}
