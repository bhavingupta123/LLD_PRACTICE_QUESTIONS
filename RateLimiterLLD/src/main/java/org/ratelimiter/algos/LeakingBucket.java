package org.ratelimiter.algos;

import java.util.concurrent.atomic.AtomicLong;

public class LeakingBucket implements IRateLimiter{

    private final long capacity;               // Maximum tokens bucket can hold
    private final long leakIntervalMillis;     // Time interval per token leak
    private final AtomicLong currentTokens;    // Current tokens in bucket
    private volatile long lastLeakTimestamp;   // Last timestamp bucket leaked tokens

    public LeakingBucket(long capacity, long leakIntervalMillis) {
        this.capacity = capacity;
        this.leakIntervalMillis = leakIntervalMillis;
        this.currentTokens = new AtomicLong(0);
        this.lastLeakTimestamp = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        leak(); // Leak tokens first

        if (currentTokens.get() < capacity) {
            currentTokens.incrementAndGet();
            return true;
        }

        return false;
    }

    private void leak() {
        long now = System.currentTimeMillis();
        long elapsedMillis = now - lastLeakTimestamp;

        long leakedTokens = elapsedMillis / leakIntervalMillis;

        if (leakedTokens > 0) {
            long newTokenCount = currentTokens.addAndGet(-leakedTokens);
            if (newTokenCount < 0) {
                currentTokens.set(0);
            }
            lastLeakTimestamp = now;
        }
    }
}