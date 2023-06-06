package com.luol.carmanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局跨域
 * @author luolei
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  //设置允许跨域访问的路径
                .allowedOriginPatterns("*")  //设置允许跨域访问的源
                .allowedMethods("*")  //允许跨域请求的方法
                .maxAge(168000)  //预检间隔时间
                .allowedHeaders("*")  //允许头部设置
                .allowCredentials(true);  //是否发送 cookie
    }


}
