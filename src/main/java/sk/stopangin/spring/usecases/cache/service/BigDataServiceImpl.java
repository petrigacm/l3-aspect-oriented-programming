package sk.stopangin.spring.usecases.cache.service;

import org.springframework.stereotype.Service;
import sk.stopangin.spring.usecases.cache.Cacheable;

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
