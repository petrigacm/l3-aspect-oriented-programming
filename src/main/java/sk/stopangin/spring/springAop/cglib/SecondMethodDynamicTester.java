package sk.stopangin.spring.springAop.cglib;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SecondMethodDynamicTester extends DynamicMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        System.out.println("From matcher..." + method.getName() + " " + System.currentTimeMillis());
        return (method.getName().contains("2"));
    }

    @Override
    public ClassFilter getClassFilter() {
        return aClass ->
                aClass == SomeService.class;
    }
}
