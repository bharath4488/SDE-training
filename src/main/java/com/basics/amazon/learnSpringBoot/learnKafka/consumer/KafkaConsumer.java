package com.basics.amazon.learnSpringBoot.learnKafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "log-events", groupId = "log-group")
    public void consumeMessage(String message) {
        log.info("Consuming message: {}", message);
    }

}
