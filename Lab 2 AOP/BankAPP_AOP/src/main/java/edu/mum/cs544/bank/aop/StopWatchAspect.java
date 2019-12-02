package edu.mum.cs544.bank.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
public class StopWatchAspect {


    @Around("execution(* edu.mum.cs544.bank.service.*.*(..))")
    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        System.out.println("TIME TO EXECUTE " + call.getSignature().getName() +" = " + totaltime + " MS");
        return retVal;
    }
//    @Around("execution(* edu.mum.cs544.bank.service.*.*(..))")
//    public void timerService(JoinPoint joinPoint) {
//        System.out.println("STOPWATCH ASPECT : " + joinPoint.getSignature().getName() + " CLASS " + joinPoint.getTarget().getClass());
//    }
}
