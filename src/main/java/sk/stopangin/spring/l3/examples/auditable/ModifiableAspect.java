package sk.stopangin.spring.l3.examples.auditable;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class ModifiableAspect {

    @Before("execution(* *.save(..)) && args(modifiable)")
    public void onSave(JoinPoint joinPoint, Modifiable modifiable) throws Throwable {
        System.out.println("Setting last modified date");
        modifiable.setLastModifiedDate(new Date());
    }
}
