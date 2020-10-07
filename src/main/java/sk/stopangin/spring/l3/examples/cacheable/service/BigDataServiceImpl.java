package sk.stopangin.spring.l3.examples.cacheable.service;

import org.springframework.stereotype.Service;
import sk.stopangin.spring.l3.examples.cacheable.Cacheable;

@Service
public class BigDataServiceImpl implements BigDataService {
    @Override
    @Cacheable
    public String getBigData() {
        System.out.println("big data service hit");
        return "bigData";
    }

    @Override
    @Cacheable
    public String getBigDataById(Integer id) {
        System.out.println("Getting big data for:" + id);
        return "bigData_" + id;
    }
}
