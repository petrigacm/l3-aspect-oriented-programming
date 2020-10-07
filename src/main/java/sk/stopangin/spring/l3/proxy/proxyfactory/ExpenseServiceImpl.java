package sk.stopangin.spring.l3.proxy.proxyfactory;

public class ExpenseServiceImpl implements ExpenseService {

    public double getSumOfExpenses() {
        System.out.println("Calculating...");
        return 10;
    }
}
