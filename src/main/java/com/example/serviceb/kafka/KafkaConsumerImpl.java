package com.example.serviceb.kafka;

import com.example.serviceb.Constants;
import com.example.serviceb.GuavaExchangerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableKafka
public class KafkaConsumerImpl implements KafkaConsumer {
    @Autowired
    private GuavaExchangerImpl guavaExchangerImpl;

    @Override
    @KafkaListener(topics = Constants.TOPIC, containerFactory = "kafkaListenerContainerFactory")

    public void listen(String message) {
        log.info("Получаем из кафки сообщение " + message);
        guavaExchangerImpl.messageReceive(message);
    }
}
