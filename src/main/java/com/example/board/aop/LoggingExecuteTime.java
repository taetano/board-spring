package com.example.board.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Log4j2
@Aspect
@Component
public class LoggingExecuteTime {
    @Pointcut("(execution(* com.example.board.*.*(..) ))")
    public void loggingPointcut() {};

    @Around("loggingPointcut()")
    public Object loggingExecution(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = pjp.proceed();

        long endTime = System.currentTimeMillis();

        log.info("execution time {}", startTime - endTime);

        return result;
    }
}
