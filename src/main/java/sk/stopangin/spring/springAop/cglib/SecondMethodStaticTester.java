package sk.stopangin.spring.springAop.cglib;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SecondMethodStaticTester extends StaticMethodMatcherPointcut {



    @Override
    public ClassFilter getClassFilter() {
        return aClass ->
                aClass == SomeService.class;
    }

    public boolean matches(Method method, Class<?> aClass) {
        System.out.println("From matcher..." +method.getName()+" "+ System.currentTimeMillis());
        return (method.getName().contains("2"));
    }
}
