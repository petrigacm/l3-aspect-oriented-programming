package sk.stopangin.spring.aspectj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class Advice {


    @Around("within(sk.stopangin.spring.aspectj.service.*Servic*)")
    public void logExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        proceedingJoinPoint.proceed();
        System.out.println(proceedingJoinPoint.getSignature().getName()+" took: "+ (System.nanoTime() - start));
    }
}
