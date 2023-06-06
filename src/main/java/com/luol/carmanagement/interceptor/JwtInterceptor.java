package com.luol.carmanagement.interceptor;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.luol.carmanagement.common.Result;
import com.luol.carmanagement.config.InterceptorConfig;
import com.luol.carmanagement.entity.AreaUser;
import com.luol.carmanagement.entity.SystemUser;
import com.luol.carmanagement.repository.SystemUserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;

/**
 * @author luolei
 */
public class JwtInterceptor implements HandlerInterceptor {


    @Autowired
    private SystemUserRepository systemUserRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)) {
            return true;
        }
        // 执行认证
        if (StrUtil.isBlank(token)) {
            return false;
        }
        // 获取 token 中的 user id
        String userId = "";
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            return false;
        }
        //根据token中的userid查询数据库 访问频率较高的话进行缓存处理
        SystemUser user = systemUserRepository.getReferenceById(Integer.valueOf(userId));
        if (user == null) {
            return false;
        }
        // 用户密码加签验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token); //验证 token
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }
}
