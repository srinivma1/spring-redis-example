/**
 * 
 */
package com.example;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Configuration;

import com.example.exceptions.CustomCacheErrorHandler;

/**
 * @author mahesh.srinivas
 *
 */
@Configuration
public class RedisConfiguration extends CachingConfigurerSupport {
    @Override
    public CacheErrorHandler errorHandler() {
        return new CustomCacheErrorHandler();
    }
}
