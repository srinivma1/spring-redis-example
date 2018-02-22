/**
 * 
 */
package com.example;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;

/**
 * @author mahesh.srinivas
 *
 */
@TestConfiguration
public  class EmbeddedRedisTestConfiguration {

  private final redis.embedded.RedisServer redisServer;

  public EmbeddedRedisTestConfiguration(@Value("${spring.redis.port}") final int redisPort) throws IOException {
    this.redisServer = new redis.embedded.RedisServer(redisPort);
  }

  @PostConstruct
  public void startRedis() {
    this.redisServer.start();
  }

  @PreDestroy
  public void stopRedis() {
    this.redisServer.stop();
  }
}
