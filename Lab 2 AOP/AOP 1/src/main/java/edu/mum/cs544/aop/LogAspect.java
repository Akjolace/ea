package edu.mum.cs544.aop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LogManager.getLogger(LogAspect.class.getName());

    @After("execution(* edu.mum.cs544.aop.EmailSender.sendEmail(..)) && args(email, message)")
    public void LogAfter(JoinPoint joinPoint, String email, String message){
//        System.out.println(new Date() + " method=" + joinPoint.getSignature().getName() +
//                " address=" + email + " message=" + message);
        logger.warn(" method = " + joinPoint.getSignature().getName() +
                "  address = " + email + "  message = " + message);
        IEmailSender emailSender = (IEmailSender) joinPoint.getTarget();
        logger.warn( " server = " + emailSender.getOutgoingMailServer());
    }


}
