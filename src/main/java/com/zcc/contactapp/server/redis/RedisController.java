package com.zcc.contactapp.server.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2019/9/3.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/test")
    @ResponseBody
    public Map<String, Object> testRedis() {
        Map<String, Object> ret = new HashMap<>();
        redisTemplate.opsForValue().set("key1", "value1");
        List list = (List) redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                operations.watch("key1");
                operations.multi();
                operations.opsForValue().set("key2", "value2");
                Object v2 = operations.opsForValue().get("key2");
                System.out.print("get v2 : " + v2);
                operations.opsForValue().set("key3", "value3");
                Object v3 = operations.opsForValue().get("key3");
                System.out.print("get v3 : " + v3);
                return operations.exec();
            }
        });
        System.out.println(list);
        ret.put("success", true);
        return ret;

    }
}
