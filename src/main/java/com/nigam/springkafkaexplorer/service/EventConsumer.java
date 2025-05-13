package com.nigam.springkafkaexplorer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventConsumer {

    @KafkaListener(topics = "${spring.kafka.producer.topic.default}", groupId = "${spring.kafka.consumer.group-id.default}")
    public void consumeMessage(String message) {
        log.info("Message Received: {}", message);
    }

}
