package com.tkx.rocketmqboot.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author tkx
 * @Date 2022 12 19 16 24
 **/
@Component
@RocketMQMessageListener(consumerGroup = "sanyouConsumer",topic = "sanyouTopic")
public class SanYouTopicListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String msg) {
        System.out.println("处理消息:"+msg);
    }
}
