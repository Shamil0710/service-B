package com.example.serviceb;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Component
public class GuavaConfig {
    @Bean
    public Cache<Instant, String> cache() {
        return CacheBuilder.newBuilder()
                .expireAfterWrite(8, TimeUnit.HOURS)
                .build();
    }
}
