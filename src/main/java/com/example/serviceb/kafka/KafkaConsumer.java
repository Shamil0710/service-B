package com.example.serviceb.kafka;

import org.springframework.kafka.annotation.KafkaListener;

public interface KafkaConsumer {
    @KafkaListener(topics = "Topick_1", containerFactory = "kafkaListenerContainerFactory")
    void listen(String message);
}
