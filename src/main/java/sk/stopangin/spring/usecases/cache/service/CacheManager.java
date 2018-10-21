package sk.stopangin.spring.usecases.cache.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheManager {
    private final ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();

    public void insert(String key, Object o) {
        cache.put(key, o);
    }

    public Object get(String key) {
        return cache.get(key);
    }
}
