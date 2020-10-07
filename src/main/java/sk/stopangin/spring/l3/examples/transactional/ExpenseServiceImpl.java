package sk.stopangin.spring.l3.examples.transactional;

import org.springframework.stereotype.Component;

@Transactional
@Component
public class ExpenseServiceImpl implements ExpenseService {

    @Override
    public void saveExpenses() {
        System.out.println("Saving expenses...");
    }
}
