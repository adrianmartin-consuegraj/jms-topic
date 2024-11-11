package com.example.jmsdemo.controller;

import com.example.jmsdemo.publisher.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //? marks this class as a rest controller for handling HTTP requests
@RequestMapping("/api/jms") //? base URL for this controller
public class JmsController {

    @Autowired //? injects the MessagePublisher service
    private MessagePublisher messagePublisher;

    @PostMapping("/send") //? maps HTTP POST request to this method
    public void sendMessage(@RequestBody String message){ //? accepts a message in the request body
        messagePublisher.sendMessage(message);
    }
}
