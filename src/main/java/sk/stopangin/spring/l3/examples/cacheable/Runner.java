package sk.stopangin.spring.l3.examples.cacheable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import sk.stopangin.spring.l3.examples.cacheable.service.BigDataService;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Runner {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Runner.class);
        BigDataService bigDataService = ac.getBean(BigDataService.class);
        bigDataService.getBigData();
        bigDataService.getBigData();
        bigDataService.getBigData();
        bigDataService.getBigData();

        bigDataService.getBigDataById(1);
        bigDataService.getBigDataById(1);
        bigDataService.getBigDataById(1);
        bigDataService.getBigDataById(1);

        bigDataService.getBigDataById(2);
        bigDataService.getBigDataById(2);
        bigDataService.getBigDataById(2);
        bigDataService.getBigDataById(2);


    }
}
