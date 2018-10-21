package sk.stopangin.spring.howproxydoesnotwork.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import sk.stopangin.spring.introduction.Transactional;

@Service
public class BigDataServiceImpl implements BigDataService {
    @Override
    public String getBigData() {
        return ((BigDataServiceImpl)AopContext.currentProxy()).getBigDataById(null);
    }

    @Override
    @Transactional
    public String getBigDataById(Integer id) {
        System.out.println("Getting big data for:" + (id == null ? "all ids" : id.toString()));
        return "bigData_" + (id == null ? "all" : id.toString());
    }
}
