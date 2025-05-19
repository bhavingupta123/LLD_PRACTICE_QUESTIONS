package org.ratelimiter.algos;

public class FixedWindowCounter implements IRateLimiter{

    private final long maxRequests;          // allowed requests per window
    private final long windowSizeInMillis;   // window size (e.g., 1000ms = 1 sec)

    private long currentWindowStart;
    private long requestCount;

    public FixedWindowCounter(long maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
        this.currentWindowStart = System.currentTimeMillis();
        this.requestCount = 0;
    }

    @Override
    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();

        if (now - currentWindowStart >= windowSizeInMillis) {
            // New window → reset
            currentWindowStart = now;
            requestCount = 0;
        }

        if (requestCount < maxRequests) {
            requestCount++;
            return true;
        }

        return false;
    }
}

//Fixed window is simple but can suffer from burst traffic at window edges.
// If you want to prevent this, look into sliding window log or sliding window counter