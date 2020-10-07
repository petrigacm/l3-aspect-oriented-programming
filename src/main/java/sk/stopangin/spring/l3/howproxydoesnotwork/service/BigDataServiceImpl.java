package sk.stopangin.spring.l3.howproxydoesnotwork.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import sk.stopangin.spring.l3.howproxydoesnotwork.Transactional;

@Service
public class BigDataServiceImpl implements BigDataService {
    @Override
    public String getBigData() {
        // return ((BigDataService) AopContext.currentProxy()).getBigDataById(null);
        return this.getBigDataById(null);
    }

    @Override
    @Transactional
    public String getBigDataById(Integer id) {
        System.out.println("Getting big data for:" + (id == null ? "all ids" : id.toString()));
        return "bigData_" + (id == null ? "all" : id.toString());
    }
}
