package org.ratelimiter.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LeakyBucketRateLimiter implements IRateLimiterStrategy {

    private final long capacity;             // Max tokens
    private final long leakRateMillis;       // One token leaks per leakRateMillis

    private static class BucketState {
        long lastLeakTimestamp;
        long tokens;
    }

    private final Map<String, BucketState> userBuckets = new ConcurrentHashMap<>();

    public LeakyBucketRateLimiter(long capacity, long leakRateMillis) {
        this.capacity = capacity;
        this.leakRateMillis = leakRateMillis;
    }

    @Override
    public synchronized boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        userBuckets.putIfAbsent(userId, new BucketState());

        BucketState state = userBuckets.get(userId);

        // Leak tokens
        long elapsed = now - state.lastLeakTimestamp;
        long leakedTokens = elapsed / leakRateMillis;

        if (leakedTokens > 0) {
            state.tokens = Math.max(0, state.tokens - leakedTokens);
            state.lastLeakTimestamp = now;
        }

        // Check if we can allow
        if (state.tokens < capacity) {
            state.tokens++;
            return true;
        }

        return false;
    }
}

