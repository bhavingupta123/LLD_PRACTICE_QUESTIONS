package org.example;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CacheRepo {

    private Map<String, CacheModel> mp = new ConcurrentHashMap<>();
    private final ScheduledExecutorService cleaner = Executors.newScheduledThreadPool(1);

    public CacheRepo() {
        cleaner.scheduleAtFixedRate(this::evictExpiredEntries, 1, 1, TimeUnit.SECONDS);
    }

    public void addToCache(String key, String value, long ttlSeconds){
        mp.put(key,new CacheModel(value, LocalDateTime.now().plusSeconds(ttlSeconds)));
    }

    public String getFromCache(String key){
        CacheModel cacheModel = mp.get(key);

        if(cacheModel==null)
            return null;
        if(LocalDateTime.now().isAfter(cacheModel.getTtl()))
            return null;

        return cacheModel.getValue();
    }

    public String removeFromCache(String key){
        mp.remove(key);
        return "removed key:" + key;
    }

    private void evictExpiredEntries() {
        for (Map.Entry<String, CacheModel> entry : mp.entrySet()) {
            if (LocalDateTime.now().isAfter(entry.getValue().getTtl())) {
                mp.remove(entry.getKey());
            }
        }
    }
}
