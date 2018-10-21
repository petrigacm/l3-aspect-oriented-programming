package sk.stopangin.spring.introduction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import sk.stopangin.spring.introduction.aspect.LastModified;
import sk.stopangin.spring.introduction.service.CacheManager;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
public class Runner {

    public static void main(String[] args) throws Exception {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Runner.class);
        CacheManager cacheManager = ac.getBean(CacheManager.class);
        cacheManager.setData("data");
        System.out.println(((LastModified) cacheManager).getLastModified());
        Thread.sleep(3000);
        cacheManager.setData("data");
        System.out.println(((LastModified) cacheManager).getLastModified());
    }
}
