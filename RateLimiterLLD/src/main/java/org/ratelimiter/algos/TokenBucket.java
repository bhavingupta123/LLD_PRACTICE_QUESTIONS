package org.ratelimiter.algos;

public class TokenBucket implements IRateLimiter{

    private final long capacity;
    private final long refillRatePerSecond; // tokens per second
    private double currentTokens;
    private long lastRefillTimestamp;

    public TokenBucket(long capacity, long refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
        this.currentTokens = capacity; // initially full
        this.lastRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        refillTokens();

        if (currentTokens >= 1) {
            currentTokens -= 1;
            return true;
        }

        return false;
    }

    private void refillTokens() {
        long now = System.nanoTime();
        double secondsPassed = (now - lastRefillTimestamp) / 1_000_000_000.0;

        double tokensToAdd = secondsPassed * refillRatePerSecond;
        if (tokensToAdd > 0) {
            currentTokens = Math.min(capacity, currentTokens + tokensToAdd);
            lastRefillTimestamp = now;
        }
    }
}
