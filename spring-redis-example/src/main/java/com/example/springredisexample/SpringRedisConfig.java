package com.example.springredisexample;

import com.example.springredisexample.entity.User;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author mahesh
 *
 */
@Configuration
@EnableCaching
public class SpringRedisConfig {

	@Bean
    private RedisTemplate<String, User> redisTemplate() {
        RedisTemplate<String, User> redisTemplate;
        redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());

        return redisTemplate;

    }
	
	@Bean
    private JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }
	
	@Bean	
	 CacheManager redisCacheManager() {
		RedisCacheManager redisCache = new RedisCacheManager(redisTemplate());
		redisCache.setDefaultExpiration(3000);
		return redisCache;
	}

}
