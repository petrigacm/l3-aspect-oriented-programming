package sk.stopangin.spring.l3.examples.secured.service;

public interface AccountService {
    Double getBalance();

    String getPromotionInfoAnonymous();

    Double insertCash(double amount);
}
