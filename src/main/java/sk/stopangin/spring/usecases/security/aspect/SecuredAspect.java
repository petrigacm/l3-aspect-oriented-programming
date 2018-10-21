package sk.stopangin.spring.usecases.security.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import sk.stopangin.spring.usecases.security.context.UserContext;

@Component
@Aspect
public class SecuredAspect {

    @Before("ServiceLevelPointcut.serviceMethod() && !ServiceLevelPointcut.isAnonymousAllowedMethod()")
    public void secure(JoinPoint joinPoint) {
        String username = UserContext.getUsername();
        if (username == null || username.equals("") || username.equals("anonymous")) {
            throw new SecurityException(username == null ? "N/A" : username + " is not allowed to access:" + getAccessedMethodDetail(joinPoint));
        }
    }

    @Before("ServiceLevelPointcut.serviceMethod() && ServiceLevelPointcut.isAnonymousAllowedMethod()")
    public void securedAnonymousAllowed(JoinPoint joinPoint) {
        String username = UserContext.getUsername();
        if (username == null || username.equals("")) {
            throw new SecurityException(username == null ? "N/A" : username + " is not allowed to access:" + getAccessedMethodDetail(joinPoint));
        }
    }

    private String getAccessedMethodDetail(JoinPoint joinPoint) {
        return joinPoint.getTarget().getClass() + "#" + joinPoint.getSignature().getName();
    }

    @Before("ServiceLevelPointcut.serviceMethod() && args(amount)")
    public void fraudDetection(JoinPoint joinPoint, Double amount) {
        System.out.println("Fraud detection in progress...");
        if (amount > 10000) {
            throw new SecurityException("Fraud detected for amount: " + amount+" while accessing:"+getAccessedMethodDetail(joinPoint));
        }
    }
}