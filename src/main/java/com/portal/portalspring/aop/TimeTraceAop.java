package com.portal.portalspring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimeTraceAop {

    /**
     * AOP (Aspect Oriented Programming)
     * @param joinPoint
     * @return
     * @throws Throwable
     */
//    @Around("execution(* com.portal.portalspring.serivce ..*(..))")
    @Around("execution(* com.portal.portalspring..*(..))")
    public Object excute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("START: {}", joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            log.info("END: {} {} ms", joinPoint.toString(), timeMs);
        }
    }

}
