package com.zcc.contactapp.server;

import com.zcc.contactapp.server.db.mybatis.ContactDao;
import com.zcc.contactapp.server.redis.RedisConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.zcc.contactapp.server.db")
@EntityScan(basePackages = "com.zcc.contactapp.server.dao")
public class ContactAppServerApplication {

    @Autowired
    SqlSessionFactory sqlSessionFactory = null;

    @Bean
    public MapperFactoryBean<ContactDao> initMyBatisContactDao() {
        MapperFactoryBean<ContactDao> bean = new MapperFactoryBean<>();
        bean.setMapperInterface(ContactDao.class);
        bean.setSqlSessionFactory(sqlSessionFactory);
        return bean;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        redisTemplate.opsForValue().set("key1", "v1");
        redisTemplate.opsForHash().put("hash", "feild", "hvalue");
        SpringApplication.run(ContactAppServerApplication.class, args);
    }

}
