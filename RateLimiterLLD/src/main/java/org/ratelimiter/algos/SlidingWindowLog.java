package org.ratelimiter.algos;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowLog implements IRateLimiter{

    private final int maxRequests;             // Max requests allowed per window
    private final long windowSizeInMillis;     // Window size (e.g., 60_000 ms = 1 min)
    private final Queue<Long> requestTimestamps;

    public SlidingWindowLog(int maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
        this.requestTimestamps = new LinkedList<>();
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();

        // Remove expired timestamps
        while (!requestTimestamps.isEmpty() && now - requestTimestamps.peek() >= windowSizeInMillis) {
            requestTimestamps.poll();
        }

        if (requestTimestamps.size() < maxRequests) {
            requestTimestamps.add(now);
            return true;
        }

        return false; // Too many requests
    }
}
