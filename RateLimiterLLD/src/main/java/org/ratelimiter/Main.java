package org.ratelimiter;

import org.ratelimiter.algos.LeakingBucket;
import org.ratelimiter.factory.RateLimiterFactory;
import org.ratelimiter.service.RateLimiterService;
import org.ratelimiter.strategy.IRateLimiterStrategy;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        LeakingBucket bucket = new LeakingBucket(5, 1000); // 5 tokens, 1 token leaks per 1s
//
//        for (int i = 1; i <= 10; i++) {
//            boolean allowed = bucket.allowRequest();
//            System.out.println("Request " + i + ": " + (allowed ? "Allowed" : "Rejected"));
//            Thread.sleep(100); // small delay between requests (faster than 1s leak rate)
//        }

        IRateLimiterStrategy strategy = RateLimiterFactory.createRateLimiter("slidinglog", 5, 3000);
        RateLimiterService service = new RateLimiterService(strategy);

        String userId = "user1";
        for (int i = 0; i < 10; i++) {
            boolean allowed = service.allowRequest(userId);
            System.out.println("Request " + (i + 1) + ": " + (allowed ? "Allowed" : "Rejected"));
            Thread.sleep(500);
        }

    }
}
