package sk.stopangin.spring.l3.examples.timed;

import org.springframework.stereotype.Service;

@Timed
@Service
public class ExpenseServiceImpl implements ExpenseService {

    public double calculate() {
        System.out.println("calculating...");
        try {
            Thread.sleep(123);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public double find() {
        System.out.println("finding...");
        return 0;
    }
}
