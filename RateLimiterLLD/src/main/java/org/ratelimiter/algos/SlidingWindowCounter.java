package org.ratelimiter.algos;

import java.util.TreeMap;

public class SlidingWindowCounter implements IRateLimiter{

    private final long maxRequests;            // Allowed requests per window
    private final long windowSizeInMillis;     // Total window size (e.g., 1 min = 60_000 ms)
    private final long bucketSizeInMillis;     // Sub-window bucket size (e.g., 1 sec = 1000 ms)

    private final TreeMap<Long, Long> buckets; // Map of timestamp -> request count

    public SlidingWindowCounter(long maxRequests, long windowSizeInMillis, long bucketSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
        this.bucketSizeInMillis = bucketSizeInMillis;
        this.buckets = new TreeMap<>();
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        long currentBucket = now / bucketSizeInMillis;

        // Remove expired buckets outside the sliding window
        long windowStartBucket = (now - windowSizeInMillis) / bucketSizeInMillis;
        buckets.headMap(windowStartBucket, false).clear();

        // Calculate total requests in current window
        long totalRequests = buckets.values().stream().mapToLong(Long::longValue).sum();

        if (totalRequests >= maxRequests) {
            return false; // Rate limit exceeded
        }

        // Increment current bucket count
        buckets.put(currentBucket, buckets.getOrDefault(currentBucket, 0L) + 1);
        return true;
    }
}
