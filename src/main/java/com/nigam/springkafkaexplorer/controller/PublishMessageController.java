package com.nigam.springkafkaexplorer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/publish-message")
public class PublishMessageController {

    @Value("${spring.kafka.producer.topic.default}")
    private String defaultTopic;

//    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/{message}")
    public ResponseEntity<String> publishMessage(@PathVariable String message) {
        for(int i = 0; i < 1000; i++) {
            //key defines the partition number, if a specific message needs to be in serial, make sure they are put into same partition
            //kafkaTemplate.send(defaultTopic, String.valueOf(i%2),message+ " "+ i);
        }
        return ResponseEntity.ok(message);
    }
}
