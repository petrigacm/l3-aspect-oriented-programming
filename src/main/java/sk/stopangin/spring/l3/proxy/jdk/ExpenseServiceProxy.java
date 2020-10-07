package sk.stopangin.spring.l3.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ExpenseServiceProxy implements InvocationHandler {

    private ExpenseService expenseService;

    public ExpenseServiceProxy(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] arguments) throws Throwable {
        System.out.println("Calling " + method.getName() + " via JDK dynamic proxy");

        Object result = method.invoke(expenseService, arguments);

        System.out.println("Called " + method.getName());

        return result;
    }
}
