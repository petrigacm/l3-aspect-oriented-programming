package sk.stopangin.spring.l3.proxy.proxyfactory;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ExpenseServiceAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Calling " + invocation.getMethod().getName() + " via proxy");
        Object result = invocation.proceed();
        System.out.println("Called " + invocation.getMethod().getName());
        return result;
    }
}
