package sk.stopangin.spring.usecases.security.service;

public interface AccountService {
    Double getBalance();

    String getPromotionInfoAnonymous();

    Double insertCash(double amount);
}
