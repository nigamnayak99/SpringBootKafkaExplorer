package com.nigam.springkafkaexplorer.configurations;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TopicConfiguration {

    @Value("${spring.kafka.producer.topic.default}")
    private String defaultTopic;

    @Value("${spring.kafka.producer.topic.user-creation}")
    private String userCreationTopic;

    //This is a non-mandatory step
    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic createNewTopic() {

//        return new NewTopic(defaultTopic, 3, (short)1);

        return TopicBuilder.name(defaultTopic)
                .partitions(2)
                .replicas(1) // Default should be one as we have only on broker in local
                .build();
    }

    @Bean
    public NewTopic createNewUserCreationTopic() {
        return TopicBuilder.name(userCreationTopic)
                .partitions(2)
                .replicas(1) // Default should be one as we have only on broker in local
                .build();
    }
}
