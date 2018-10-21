package sk.stopangin.spring.usecases.security;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.stopangin.spring.usecases.security.context.UserContext;
import sk.stopangin.spring.usecases.security.service.AccountService;

public class Runner {

    public static void main(String[] args) {
        UserContext.setUsername("vajec");
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        AccountService accountService = ac.getBean(AccountService.class);
        Double balance = accountService.getBalance();
        System.out.println("Accounts balance: " + balance);
        String promotionInfoAnonymous = accountService.getPromotionInfoAnonymous();
        System.out.println("Account promotion: " + promotionInfoAnonymous);
        accountService.insertCash(10001);
    }
}
