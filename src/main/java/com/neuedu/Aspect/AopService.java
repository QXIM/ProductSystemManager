package com.neuedu.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopService {

    @Autowired
    AopDao aopDao;

    public void setAopDao(AopDao aopDao) {
        this.aopDao = aopDao;
    }

    @Pointcut("execution(* com.neuedu.serviceImpl.*.*(..))")
    public  void  test(){}


    @Around("test()")
    public Object addAspect(ProceedingJoinPoint proceedingJoinPoint){

        System.out.println("====环绕通知====");
        String className= proceedingJoinPoint.getTarget().getClass().getName();
        String methodName=proceedingJoinPoint.getSignature().getName();
        Object o=null;
        try {
            o=proceedingJoinPoint.proceed();
            LogBean logBean=new LogBean(1,className+methodName);
            System.out.println(className+methodName);
            o=aopDao.addAspect(logBean);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return o;

    }

}
