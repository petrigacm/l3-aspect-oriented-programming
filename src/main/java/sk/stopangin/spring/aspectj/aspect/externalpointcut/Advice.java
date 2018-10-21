package sk.stopangin.spring.aspectj.aspect.externalpointcut;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

//@Aspect
//@Configuration
public class Advice  {

//    @Around("within(sk.stopangin.spring.aspectj.service.*Servic*)")
    public void logExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        proceedingJoinPoint.proceed();
        System.out.println(proceedingJoinPoint.getSignature().getName() + " took: " + (System.nanoTime() - start));
    }
}
