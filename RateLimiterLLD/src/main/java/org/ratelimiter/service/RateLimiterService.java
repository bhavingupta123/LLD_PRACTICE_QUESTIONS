package org.ratelimiter.service;

import org.ratelimiter.strategy.IRateLimiterStrategy;

public class RateLimiterService {

    private final IRateLimiterStrategy rateLimiterStrategy;

    public RateLimiterService(IRateLimiterStrategy rateLimiterStrategy) {
        this.rateLimiterStrategy = rateLimiterStrategy;
    }

    public boolean allowRequest(String userId) {
        return rateLimiterStrategy.allowRequest(userId);
    }
}

