package sk.stopangin.spring.l3.howproxydoesnotwork;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import sk.stopangin.spring.l3.howproxydoesnotwork.service.BigDataService;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(exposeProxy = true)
public class Runner {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);

        System.out.println(context.getBean(BigDataService.class).getBigData());
    }
}
