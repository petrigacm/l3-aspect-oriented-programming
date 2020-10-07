package sk.stopangin.spring.l3.proxy.basic;

public class Runner {
    public static void main(String[] args) {
        ExpenseService expenseService = new ExpenseServiceProxy(new ExpenseServiceImpl());

        expenseService.getSumOfExpenses();
    }
}
