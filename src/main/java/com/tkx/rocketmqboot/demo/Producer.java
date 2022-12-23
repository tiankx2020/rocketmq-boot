package com.tkx.rocketmqboot.demo;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * @Author tkx
 * @Date 2022 12 19 15 42
 **/
public class Producer {
    public static void main(String[] args) throws UnsupportedEncodingException, MQClientException, MQBrokerException, RemotingException, InterruptedException {
        // 指定nameserver的地址
        DefaultMQProducer producer = new DefaultMQProducer("sanyouProducer");

        producer.setNamesrvAddr("139.196.139.232:9876");

        producer.setSendMsgTimeout(60000);

        producer.start();


        Message msg = new Message("sanyouTopic","TagA","三友的悲情日记".getBytes(RemotingHelper.DEFAULT_CHARSET));
        //发送消息并得到消息的发送结果，然后打印
        SendResult sendResult  =producer.send(msg);

        System.out.println("result:"+sendResult);

        // 关闭生产者
        producer.shutdown();

    }
}
