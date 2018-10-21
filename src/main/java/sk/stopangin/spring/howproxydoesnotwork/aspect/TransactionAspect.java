package sk.stopangin.spring.howproxydoesnotwork.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionAspect {

    @Around("@annotation(sk.stopangin.spring.introduction.Transactional)")
    public void doIntransaction(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println(methodName + " is running in transaction.");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println(methodName + " after transaction");
    }
}

