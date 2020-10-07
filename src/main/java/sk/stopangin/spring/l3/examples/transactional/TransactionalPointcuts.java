package sk.stopangin.spring.l3.examples.transactional;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionalPointcuts {

    @Pointcut("@within(sk.stopangin.spring.l3.examples.transactional.Transactional)")
    public void transactionalClass() {
    }

    @Pointcut("@annotation(sk.stopangin.spring.l3.examples.transactional.Transactional)")
    public void transactionalMethod() {
    }
}
