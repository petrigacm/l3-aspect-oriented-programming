package sk.stopangin.spring.l3.proxy.proxyfactory;

import org.springframework.aop.framework.ProxyFactory;

public class Runner {

    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new ExpenseServiceImpl());
        factory.addInterface(ExpenseService.class);
        factory.addAdvice(new ExpenseServiceAdvice());

        ExpenseService expenseService = (ExpenseService) factory.getProxy();

        expenseService.getSumOfExpenses();
    }
}
