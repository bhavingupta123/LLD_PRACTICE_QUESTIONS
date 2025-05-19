package org.ratelimiter.strategy;

public interface IRateLimiterStrategy {
    boolean allowRequest(String userId);
}