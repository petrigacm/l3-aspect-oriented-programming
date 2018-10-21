package sk.stopangin.spring.aspectj.service;

import org.springframework.stereotype.Service;

@Service
public class CommonService {
    public void doSomething(){
        System.out.println("something common");
    }
}
