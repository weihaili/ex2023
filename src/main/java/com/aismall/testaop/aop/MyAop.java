package com.aismall.testaop.aop;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.TransactionManager;
import java.util.Arrays;

@Component
@Aspect
public class MyAop {

    @Pointcut("execution(public * com.aismall.testaop.controller.*.*(..))")
    public void log() {
        System.out.println("pointcut sign...");
    }

    @Before("log()")
    public void doBefore(JoinPoint jp) throws Throwable{
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("url: "+ request.getRequestURI());
        System.out.println("http method: "+ request.getMethod());
        System.out.println("class method: "+ jp);
        System.out.println("args: "+ Arrays.toString(jp.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "log()")
    public void doAfterReturning(Object ret) throws Throwable {
        System.out.println("returning advice: ret:" + ret);
    }

    @AfterThrowing(throwing = "ex", pointcut = "log()")
    public void throwss(JoinPoint jp, Exception ex) {
        System.out.println("exception advice: method execute error .....");
        System.out.println("occur exception method :" + jp);
        System.out.println("exception type:"+ ex);
    }

    @After("log()")
    public void after(JoinPoint jp) {
        System.out.println("after advice: must execute....");
    }

    public void test() {
        ProducerRecord record;

        RecordMetadata metadata;

        Error error;

        RuntimeException runtimeException;

        Runtime runtime;

        System system;

        ClassLoader loader;
    }
}
