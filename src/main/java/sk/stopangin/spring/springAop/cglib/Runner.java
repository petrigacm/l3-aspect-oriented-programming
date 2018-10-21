package sk.stopangin.spring.springAop.cglib;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class Runner {
    public static void main(String[] args) {
        SomeService someService = new SomeService();
//        https://play.google.com/books/reader?id=N-U5DwAAQBAJ&hl=sk&printsec=frontcover&pg=GBS.PA249.w.6.1.57.0.2
//        either cglib or jdk

        //CGLIB:
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new ServiceDecorator()); // pouzive DefaultPointcutAdvisor -tzn. vsetky metody targetu budu advisovane
        proxyFactory.setTarget(someService);

        SomeService someServiceProxy = (SomeService) proxyFactory.getProxy();
        someServiceProxy.doSomething();
        someServiceProxy.doSomething2();
        System.out.println("--------------");

        ProxyFactory proxyFactory2 = new ProxyFactory();
        proxyFactory2.setTarget(someService);
        Pointcut pointcut = new SecondMethodStaticTester();
        Advice advice = new ServiceDecorator();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
        proxyFactory2.addAdvisor(advisor);

        SomeService someServiceProxy2 = (SomeService) proxyFactory2.getProxy();
        someServiceProxy2.doSomething();
        someServiceProxy2.doSomething2();
        someServiceProxy2.doSomething2();
        System.out.println("--------------");
    }
}
