package com.luol.carmanagement.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
/**
 * @author luolei
 */
public class TokenUtils {

    public static String getToken(String userId,String sign){
        return JWT.create().withAudience(userId) // 将 user id 保存到 token 里面 作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(),2)) //两小时后token过期
                .sign(Algorithm.HMAC256(sign)); // 以 sign 作为 token 的密钥
    }


    /**
     * 根据token获取用户id
     * @param token
     * @return
     */
    public static Integer getUserIdByToken(String token){
        return Integer.valueOf(JWT.decode(token).getAudience().get(0));
    }

}
