package sk.stopangin.spring.usecases.security.aspect;

import org.aspectj.lang.annotation.Pointcut;

public interface ServiceLevelPointcut {

    @Pointcut("within(sk.stopangin.spring.usecases.security.service.*)")
    static void serviceMethod() {
    }

    @Pointcut("execution(* sk.stopangin.spring.usecases.security.service.*.*Anonymous(..))")
    static void isAnonymousAllowedMethod() {
    }
    @Pointcut("execution(* sk.stopangin.spring.usecases.security.service.*.*Cash(..))")
    static void forFraudDetection(){}
}
