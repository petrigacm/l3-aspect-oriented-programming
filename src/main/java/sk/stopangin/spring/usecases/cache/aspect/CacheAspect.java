package sk.stopangin.spring.usecases.cache.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import sk.stopangin.spring.usecases.cache.service.BigDataService;
import sk.stopangin.spring.usecases.cache.service.CacheManager;

@Component
@Aspect
public class CacheAspect {
    private CacheManager cacheManager;

    public CacheAspect(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }


    @Around("@annotation(sk.stopangin.spring.usecases.cache.Cacheable))")
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

