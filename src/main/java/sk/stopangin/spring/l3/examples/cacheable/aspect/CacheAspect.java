package sk.stopangin.spring.l3.examples.cacheable.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import sk.stopangin.spring.l3.examples.cacheable.service.CacheManager;

@Component
@Aspect
public class CacheAspect {
    private CacheManager cacheManager;

    public CacheAspect(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Around("@annotation(sk.stopangin.spring.l3.examples.cacheable.Cacheable))")
    public Object doCache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("hello from cache aspect");

        String cacheHash = String.valueOf(proceedingJoinPoint.getSignature().getName().hashCode());
        Object[] joinPointArgs = proceedingJoinPoint.getArgs();
        for (Object joinPointArg : joinPointArgs) {
            cacheHash = String.valueOf((cacheHash + joinPointArg.hashCode()).hashCode());
        }
        if (cacheManager.get(cacheHash) == null) {
            Object methodResult = proceedingJoinPoint.proceed();
            cacheManager.insert(cacheHash, methodResult);
        }
        return cacheManager.get(cacheHash);
    }
}

