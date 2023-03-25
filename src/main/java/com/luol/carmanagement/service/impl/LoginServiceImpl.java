package com.luol.carmanagement.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Console;
import com.alibaba.fastjson.JSON;
import com.luol.carmanagement.entity.AreaUser;
import com.luol.carmanagement.entity.SystemUser;
import com.luol.carmanagement.repository.SystemUserRepository;
import com.luol.carmanagement.service.LoginService;
import jakarta.annotation.Resource;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;


/**
 * @author luolei
 */
@Service
public class LoginServiceImpl implements LoginService {


    @Resource
    private SystemUserRepository systemUserRepository;


    @Override
    public String userLogin(String userName, String password) {
        // 校验用户
        SystemUser systemUser = systemUserRepository.findSystemUserByUserNameAndPassword(userName, password);

        if (!BeanUtil.isEmpty(systemUser)) {
            Console.log(JSON.toJSONString(systemUser));
        }
        // 登录成功生成token信息返回

        return null;
    }
}
