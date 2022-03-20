package org.tartea.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerListener.class);


    @KafkaListener(topics = "first_topic", id = "kafka")
    public void listen(String message) {
        logger.info("收到消息listen： {}", message);
    }


    @KafkaListener(topics = "first_topic", id = "kafkaconsumer1")
    public void listener(String message) {
        logger.info("收到消息listener： {}", message);
    }
}
