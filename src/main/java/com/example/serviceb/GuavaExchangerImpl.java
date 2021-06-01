package com.example.serviceb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.Cache;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@Service
public class GuavaExchangerImpl implements GuavaExchanger {

    private String json;

    @Autowired
    private Cache cache;

    public void messageReceive(String msg) {
        log.info("Помещаем в лог сообщение " + msg);
        cache.put(LocalDateTime.now(), msg);
    }

    @Override
    public String messageToReade() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return json = objectMapper.writeValueAsString(cache.asMap());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
