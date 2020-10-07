package sk.stopangin.spring.l3.examples.timed;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimedAspect {

    //    @Around("@annotation(sk.stopangin.spring.l3.usecases.timed.Timed) || @within(sk.stopangin.spring.l3.usecases.timed.Timed)")
    @Around("execution(* *.find(..))")
    public Object timed(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        Object result = proceedingJoinPoint.proceed();
        System.out.println(proceedingJoinPoint.getSignature().getName() + " took " + ((System.nanoTime() - start) / 1000000f) + "ms");
        return result;
    }
}
