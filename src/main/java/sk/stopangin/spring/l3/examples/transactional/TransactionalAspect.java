package sk.stopangin.spring.l3.examples.transactional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionalAspect {

    @Around("TransactionalPointcuts.transactionalClass() || TransactionalPointcuts.transactionalMethod()")
    public Object doInTransaction(ProceedingJoinPoint joinPoint) {
        System.out.println("Starting transaction");

        Object result;
        try {
            result = joinPoint.proceed();
            System.out.println("Committing transaction");
        } catch (Throwable throwable) {
            System.out.println("Rolling back transaction");
            throw new RuntimeException("Transaction had to be rolled back");
        }

        return result;
    }
}
