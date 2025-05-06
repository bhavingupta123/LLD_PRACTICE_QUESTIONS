package org.example;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        CacheRepo cacheRepo = new CacheRepo();

        cacheRepo.addToCache("1", "hi", 1);   // 1 second TTL
        cacheRepo.addToCache("2", "bye", 3);  // 3 seconds TTL

        System.out.println("Immediately: " + cacheRepo.getFromCache("1")); // hi

        Thread.sleep(2000); // sleep for 2 seconds

        System.out.println("After 2s (key 1): " + cacheRepo.getFromCache("1")); // null
        System.out.println("After 2s (key 2): " + cacheRepo.getFromCache("2")); // bye

    }
}
