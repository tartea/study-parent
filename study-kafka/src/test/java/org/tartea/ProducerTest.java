package org.tartea;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.ExecutionException;

@SpringBootTest
public class ProducerTest {

    private static final Logger logger = LoggerFactory.getLogger(ProducerTest.class);
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void testSendDefault() throws ExecutionException, InterruptedException {
        String data = "data";
        /// 发送消息至默认topic
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.sendDefault(data);
        buildCallBack(future, data);
    }

    @Test
    public void testSendTopic() throws ExecutionException, InterruptedException {
        String message = "data";
        String topicName = "first_topic";
        /// 发送消息至默认topic
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);
        buildCallBack(future, message);
    }

    private void buildCallBack(ListenableFuture<SendResult<String, String>> future, String message) {
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onFailure(Throwable throwable) {
                logger.info("消息 [{}] 发送失败，错误原因: {}", message, throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("消息 [{}] 发送成功，当前 partition: {}，当前 offset: {}", message,
                        result.getRecordMetadata().partition(), result.getRecordMetadata().offset());
            }
        });
    }
}
