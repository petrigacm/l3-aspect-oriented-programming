package sk.stopangin.spring.aspectj.aspect.externalpointcut;

import org.aspectj.lang.annotation.Pointcut;

public interface Pointcuts {

    @Pointcut("within(sk.stopangin.spring.aspectj.service.*Servic*)")
    static void serviceCall(){}
}
