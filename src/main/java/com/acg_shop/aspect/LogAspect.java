package com.acg_shop.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * LogAspect 日志记录
 * Created by mac_zly on 2017/5/19.
 */

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LogManager.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.acg_shop.controller.GoodController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void before(JoinPoint joinPoint) {
        logger.info("方法执行前记录=====================");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("请求的URL: url={}", request.getRequestURL());
        logger.info("请求的方法: method={}", request.getMethod());
        logger.info("请求的IP: ip={}", request.getRemoteAddr() + ":" + request.getRemoteHost());
        logger.info("请求的方法名: class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("请求的参数：class_args={}", joinPoint.getArgs());
    }

    // 返回的值
    @AfterReturning(returning = "obj", pointcut = "log()")
    public void afterReturning(Object obj) {
        if (obj == null) {
            logger.info("response={}", "void");
        } else {
            logger.info("response={}", obj);
        }
    }

    @After("log()")
    public void after() {
        logger.info("方法执行后记录=====================");
    }

}
