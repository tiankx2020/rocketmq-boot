package com.tkx.rocketmqboot;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author tkx
 * @Date 2022 12 19 16 27
 **/
@SpringBootTest(classes = RocketmqBootApplication.class)
@RunWith(SpringRunner.class)
public class RocketMQTest {

    @Resource
    private RocketMQTemplate template;


    // 创建的一个消费者
    @Test
    public void send() throws InterruptedException {
        template.convertAndSend("sanyouTopic","三友的Java日记");
        // Thread.sleep(60000);
    }
}
