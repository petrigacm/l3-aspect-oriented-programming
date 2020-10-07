package sk.stopangin.spring.l3.proxy.basic;

public class ExpenseServiceProxy implements ExpenseService {

    private ExpenseService proxiedService;

    public ExpenseServiceProxy(ExpenseService proxiedService) {
        this.proxiedService = proxiedService;
    }

    @Override
    public double getSumOfExpenses() {
        System.out.println("Calling getSumOfExpenses via basic proxy");
        double result = proxiedService.getSumOfExpenses();
        System.out.println("Called getSumOfExpenses");
        return result;
    }
}
