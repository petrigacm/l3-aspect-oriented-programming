package sk.stopangin.spring.springAop.cglib;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ServiceDecorator implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("before from proxy");
        Object proceed = methodInvocation.proceed();
        System.out.println("after invocation");
        return proceed;
    }
}
