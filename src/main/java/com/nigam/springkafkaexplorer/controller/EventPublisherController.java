package com.nigam.springkafkaexplorer.controller;


import com.nigam.springkafkaexplorer.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/publish-event")
public class EventPublisherController {

    @Value("${spring.kafka.producer.topic.user-creation}")
    private String userCreationTopic;

    private final KafkaTemplate<Long, UserDTO> kafkaTemplate;

    @PostMapping(path= "/user")
    public void publishUserCreationEvent(@RequestBody UserDTO userDTO) {
        kafkaTemplate.send(userCreationTopic, userDTO);
    }

}
