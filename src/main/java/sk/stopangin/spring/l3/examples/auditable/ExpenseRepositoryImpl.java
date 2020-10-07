package sk.stopangin.spring.l3.examples.auditable;

import org.springframework.stereotype.Repository;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {
    @Override
    public void save(Expense expense) {
        System.out.println("Saving expense...");
    }
}
