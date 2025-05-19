package org.ratelimiter.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowRateLimiter implements IRateLimiterStrategy {

    private final long maxRequests;
    private final long windowSizeInMillis;

    private static class UserWindow {
        long windowStart;
        long requestCount;
    }

    private final Map<String, UserWindow> userWindows = new ConcurrentHashMap<>();

    public FixedWindowRateLimiter(long maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
    }

    @Override
    public synchronized boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        userWindows.putIfAbsent(userId, new UserWindow());

        UserWindow userWindow = userWindows.get(userId);

        if (now - userWindow.windowStart >= windowSizeInMillis) {
            // Start a new window
            userWindow.windowStart = now;
            userWindow.requestCount = 0;
        }

        if (userWindow.requestCount < maxRequests) {
            userWindow.requestCount++;
            return true;
        }

        return false; // Exceeded
    }
}

