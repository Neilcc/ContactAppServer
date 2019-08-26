package com.zcc.contactapp.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.zcc.contactapp.server.db")
@EntityScan(basePackages = "com.zcc.contactapp.server.dao")
public class ContactAppServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactAppServerApplication.class, args);
    }

}
