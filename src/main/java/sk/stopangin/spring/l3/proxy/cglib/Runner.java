package sk.stopangin.spring.l3.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class Runner {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ExpenseServiceImpl.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, arguments, proxy) -> {
            System.out.println("Calling " + method.getName() + " via CGLIB proxy");
            Object result = proxy.invokeSuper(obj, args);
            System.out.println("Called " + method.getName());
            return result;
        });

        ExpenseServiceImpl expenseService = (ExpenseServiceImpl) enhancer.create();

        System.out.println("Sum of expenses: " + expenseService.getSumOfExpenses());
    }
}
