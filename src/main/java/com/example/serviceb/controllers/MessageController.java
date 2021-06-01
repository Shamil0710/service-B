package com.example.serviceb.controllers;

import com.example.serviceb.GuavaExchanger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MessageController {

    @Autowired
    private GuavaExchanger guavaExchanger;

    @GetMapping("/getmessage")
    public String getMessage() {
        log.info("Выводим сообщения");
        return guavaExchanger.messageToReade();
    }

}
