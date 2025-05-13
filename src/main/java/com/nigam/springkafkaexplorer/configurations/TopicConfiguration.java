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

    @Value("${topic.default}")
    private String defaultTopic;

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
                .partitions(3)
                .replicas(1) // Default should be one as we have only on broker in local
                .compact()
                .build();
    }
}
