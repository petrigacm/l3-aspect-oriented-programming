package sk.stopangin.spring.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.stopangin.spring.aspectj.service.CommonService;
import sk.stopangin.spring.aspectj.service.MagicServic;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        CommonService commonService = ac.getBean(CommonService.class);
        MagicServic magicService = ac.getBean(MagicServic.class);
        commonService.doSomething();
        magicService.doMageic();
    }
}
