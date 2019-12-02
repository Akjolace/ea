package edu.mum.cs544.bank.aop;


import edu.mum.cs544.bank.logging.ILogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DaoAspect {

//    @Autowired
    private ILogger logger;

    @Autowired
    public DaoAspect(ILogger logger){
        this.logger = logger;
    }

    @After("execution(* edu.mum.cs544.bank.dao.*.*(..))")
    public void LogAfter(JoinPoint joinPoint){
        logger.log("LOGGING ASPECT " + joinPoint.getSignature().getName() + " CLASS : " + joinPoint.getTarget().getClass());
//        System.out.println("LOGGING ASPECT : " + joinPoint.getSignature().getName());
    }
}
