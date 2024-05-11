package com.basics.amazon.learnSpringBoot.learnKafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(String msg) {
        log.info("Publishing message to log-events Topic");
        kafkaTemplate.send("log-events", msg);
    }

}
