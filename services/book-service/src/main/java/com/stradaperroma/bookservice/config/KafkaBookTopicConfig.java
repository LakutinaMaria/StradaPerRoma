package com.stradaperroma.bookservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaBookTopicConfig {

    @Value("${kafka.topic-name:book-topic}")
    private String topicName;

    @Bean
    public NewTopic bookTopic(){
        return TopicBuilder.name(topicName).build();
    }
}
