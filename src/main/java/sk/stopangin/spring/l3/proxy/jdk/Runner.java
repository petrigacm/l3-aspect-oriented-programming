package sk.stopangin.spring.l3.proxy.jdk;

import java.lang.reflect.Proxy;

public class Runner {

    public static void main(String[] args) {
        ExpenseService expenseService = (ExpenseService) Proxy.newProxyInstance(
                Runner.class.getClassLoader(),
                new Class[]{ExpenseService.class},
                new ExpenseServiceProxy(new ExpenseServiceImpl())
        );

        expenseService.getSumOfExpenses();
    }
}
