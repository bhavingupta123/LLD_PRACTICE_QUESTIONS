package org.ratelimiter.strategy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SlidingWindowLogRateLimiter implements IRateLimiterStrategy {

    private final int maxRequests;
    private final long windowSizeInMillis;
    private final Map<String, Queue<Long>> userRequestLogs = new HashMap<>();

    public SlidingWindowLogRateLimiter(int maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
    }

    @Override
    public synchronized boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        userRequestLogs.putIfAbsent(userId, new LinkedList<>());
        Queue<Long> logs = userRequestLogs.get(userId);

        while (!logs.isEmpty() && now - logs.peek() >= windowSizeInMillis) {
            logs.poll();
        }

        if (logs.size() < maxRequests) {
            logs.add(now);
            return true;
        }

        return false;
    }
}

