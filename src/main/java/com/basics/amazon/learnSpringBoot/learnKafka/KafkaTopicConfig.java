package com.basics.amazon.learnSpringBoot.learnKafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic getNewLogEventsTopic() {
        return new NewTopic("log-events", 1, (short) 1);
    }

}
