package com.nigam.springkafkaexplorer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/{message}")
    public ResponseEntity<String> publishMessage(@PathVariable String message) {
        kafkaTemplate.send("ide-quickstart-events", message);
        return ResponseEntity.ok(message);
    }
}
