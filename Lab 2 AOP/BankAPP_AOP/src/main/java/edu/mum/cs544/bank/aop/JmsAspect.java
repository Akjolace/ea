package edu.mum.cs544.bank.aop;

import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JmsAspect {

    private ILogger logger;

    @Autowired
    public JmsAspect(ILogger logger){
        this.logger = logger;
    }

    @After("execution(* edu.mum.cs544.bank.jms.JMSSender.sendJMSMessage(..)) && args(text)")
    public void jmsLog (JoinPoint joinPoint, String text){
        logger.log("JAVA MESSAGE SENT ASPECT : " + joinPoint.getSignature().getName() + " XXXXXX : " + joinPoint.getTarget().getClass());
        logger.log("MESSAGE IS : " + text);
    }
}
