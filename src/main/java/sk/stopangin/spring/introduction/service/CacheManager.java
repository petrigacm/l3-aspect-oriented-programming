package sk.stopangin.spring.introduction.service;

import org.springframework.stereotype.Service;

@Service
public class CacheManager {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        System.out.println("setting data");
        this.data = data;
    }
}
