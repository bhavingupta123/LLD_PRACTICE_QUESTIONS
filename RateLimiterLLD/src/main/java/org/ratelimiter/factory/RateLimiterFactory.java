package org.ratelimiter.factory;

import org.ratelimiter.strategy.FixedWindowRateLimiter;
import org.ratelimiter.strategy.IRateLimiterStrategy;
import org.ratelimiter.strategy.LeakyBucketRateLimiter;
import org.ratelimiter.strategy.SlidingWindowLogRateLimiter;

public class RateLimiterFactory {

    public static IRateLimiterStrategy createRateLimiter(String type, long maxRequests, long windowSize) {
        switch (type.toLowerCase()) {
            case "fixed":
                return new FixedWindowRateLimiter(maxRequests, windowSize);
            case "slidinglog":
                return new SlidingWindowLogRateLimiter((int) maxRequests, windowSize);
            case "leaky":
                return new LeakyBucketRateLimiter(maxRequests, windowSize); // windowSize = leakRateMillis
            default:
                throw new IllegalArgumentException("Unknown limiter type: " + type);
        }
    }
}
