package com.zcc.contactapp.server.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc on 2019/9/6.
 */
@RestController
@RequestMapping("/redis")
public class RedisDBController {

    @Autowired
    private RedisCacheService redisCacheService;

}
