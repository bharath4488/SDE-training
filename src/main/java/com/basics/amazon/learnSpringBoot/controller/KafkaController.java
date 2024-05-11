package com.basics.amazon.learnSpringBoot.controller;

import com.basics.amazon.learnSpringBoot.learnKafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kafka")
@Slf4j
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @PostMapping
    public ResponseEntity<String> publishMessage(@RequestBody String msg) {
        this.kafkaProducer.publishMessage(msg);
        return ResponseEntity.ok("Message published");
    }

    @GetMapping("/loop-logs-test")
    public ResponseEntity<String> publishLogMessageInLoop() {
        int count = 200;
        while(count > 0) {
            this.kafkaProducer.publishMessage("Log line number " + count);
            count--;
        }

        return ResponseEntity.ok("Message published");
    }

}
