package com.zcc.contactapp.server.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by cc on 2019/9/3.
 */
@Configuration
public class RedisConfig {

    private RedisConnectionFactory redisConnectionFactory = null;

    private ThreadPoolTaskScheduler threadPoolTaskScheduler = null;

    @Autowired
    private RedisMsgListener redisMsgListener;

    @Bean
    public ThreadPoolTaskScheduler initTaskScheduler() {
        if (threadPoolTaskScheduler == null) {
            threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
            threadPoolTaskScheduler.setPoolSize(20);
        }
        return this.threadPoolTaskScheduler;
    }

    @Bean
    public RedisMessageListenerContainer initRedisContainer() {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        redisMessageListenerContainer.setTaskExecutor(initTaskScheduler());
        Topic topic = new ChannelTopic("topic1");
        redisMessageListenerContainer.addMessageListener(redisMsgListener, topic);
        return redisMessageListenerContainer;
    }


    @Bean(name = "RedisConnectionFactory")
    public RedisConnectionFactory initRedisConnectionFactory() {
        if (this.redisConnectionFactory == null) {
            JedisPoolConfig poolConfig = new JedisPoolConfig();
            poolConfig.setMaxIdle(30);
            poolConfig.setMaxTotal(50);
            poolConfig.setMaxWaitMillis(2000);
            JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(poolConfig);
            RedisStandaloneConfiguration standaloneConfiguration = jedisConnectionFactory.getStandaloneConfiguration();
            standaloneConfiguration.setHostName("127.0.0.1");
            standaloneConfiguration.setPort(6379);
//            standaloneConfiguration.setPassword("123456");
            this.redisConnectionFactory = jedisConnectionFactory;
        }
        return redisConnectionFactory;
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> initRedisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        RedisSerializer serializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setHashKeySerializer(serializer);
        redisTemplate.setHashValueSerializer(serializer);
        redisTemplate.setConnectionFactory(initRedisConnectionFactory());
        return redisTemplate;
    }

}
