package sk.stopangin.spring.usecases.security.service;

import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private Double amount = Math.random() * 1000;

    @Override
    public Double getBalance() {
        System.out.println("Getting balance from account:" + amount);
        return amount;
    }

    @Override
    public String getPromotionInfoAnonymous() {
        System.out.println("getting promotion info");
        return "the best promotion";
    }

    @Override
    public Double insertCash(double amount) {
        System.out.println("inserting cash:" + amount);
        return this.amount += amount;
    }
}
