package com.luol.carmanagement.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装一个返回 含令牌的用户对象
 * @author luolei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenVo {

    /**
     * 用户名
     */

    private  String userName;
    /**
     * 令牌名
     */
    private String token;

}
