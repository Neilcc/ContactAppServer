package com.zcc.contactapp.server.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by cc on 2019/9/4.
 */
@Component
public class RedisMsgListener implements MessageListener {
    @Override
    public void onMessage(Message message, @Nullable byte[] pattern) {
        String body = new String(message.getBody());
        String topic = new String(pattern);
        System.out.println(body);
        System.out.println(topic);
    }
}
