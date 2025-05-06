package org.example;

import java.time.LocalDateTime;

public class CacheModel {

    String value;
    LocalDateTime ttl;

    public CacheModel(String value, LocalDateTime ttl) {
        this.value = value;
        this.ttl = ttl;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDateTime getTtl() {
        return ttl;
    }

    public void setTtl(LocalDateTime ttl) {
        this.ttl = ttl;
    }
}
