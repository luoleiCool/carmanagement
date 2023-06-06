package com.luol.carmanagement.aspect;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.luol.carmanagement.annotation.ActionLog;
import com.luol.carmanagement.entity.SystemLog;
import com.luol.carmanagement.repository.SystemLogRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luolei
 */
@Aspect
@Component
@Slf4j
public class LogAspect {


    @Resource
    private SystemLogRepository systemLogRepository;

    @Pointcut("@annotation(com.luol.carmanagement.annotation.ActionLog)")
    public void Pointcut() {

    }

    //@AfterThrowing: 异常通知
    @AfterThrowing(value = "Pointcut()", throwing = "e")
    public void afterReturningMethod(JoinPoint joinPoint, Exception e) {
        log.info("调用了异常通知");
    }

    //@Around：环绕通知
    @Around("Pointcut()")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        Map<String, Object> data = new HashMap<>();
        //获取目标类名称
        String clazzName = pjp.getTarget().getClass().getName();
        //获取目标类方法名称
        String methodName = pjp.getSignature().getName();
        //记录类名称
        data.put("clazzName", clazzName);
        //记录对应方法名称
        data.put("methodName", methodName);
        //记录请求参数
        data.put("params", pjp.getArgs());
        //开始调用时间
        long start = System.currentTimeMillis();
        //获取需要的信息
        String context=getServiceMthodDescription(pjp);
        data.put("description", context);
        //计时并调用目标函数
        Object result = pjp.proceed();
        Long time = System.currentTimeMillis() - start;
        //记录返回参数
        data.put("result", result);
        //设置消耗总时间
        data.put("consumeTime", time);
        //创建时间
        data.put("createTime", DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        //数据落库
        systemLogRepository.save(BeanUtil.mapToBean(data, SystemLog.class,true, CopyOptions.create()));
        log.info(JSON.toJSONString(data));
        return result;
    }

    /**
     *获取自定义注解里的日志描述
     * @param joinPoint
     * @return 返回注解里面的日志描述
     * @throws Exception
     */
    private String getServiceMthodDescription(JoinPoint joinPoint)
            throws Exception {
        //类名
        String targetName = joinPoint.getTarget().getClass().getName();
        //方法名
        String methodName = joinPoint.getSignature().getName();
        //参数
        Object[] arguments = joinPoint.getArgs();
        //通过反射获取示例对象
        Class targetClass = Class.forName(targetName);
        //通过实例对象方法数组
        Method[] methods = targetClass.getMethods();
        String description = "";
        for(Method method : methods) {
            //判断方法名是不是一样
            if(method.getName().equals(methodName)) {
                //对比参数数组的长度
                Class[] clazzs = method.getParameterTypes();
                if(clazzs.length == arguments.length) {
                    //获取注解里的日志信息
                    description = method.getAnnotation(ActionLog.class).description();
                    break;
                }
            }
        }
        return description;
    }


}
