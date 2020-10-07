package sk.stopangin.spring.l3.examples.secured.aspect;

import org.aspectj.lang.annotation.Pointcut;

public interface ServiceLevelPointcut {

    @Pointcut("within(sk.stopangin.spring.l3.examples.secured.service.*)")
    static void serviceMethod() {
    }

    @Pointcut("execution(* sk.stopangin.spring.l3.examples.secured.service.*.*Anonymous(..))")
    static void isAnonymousAllowedMethod() {
    }

    @Pointcut("execution(* sk.stopangin.spring.l3.examples.secured.service.*.*Cash(..))")
    static void forFraudDetection() {
    }
}
