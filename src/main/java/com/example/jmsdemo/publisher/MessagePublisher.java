package com.example.jmsdemo.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service //? marks this class as a service component, making it available for dependency injection
public class MessagePublisher {

    private static final String DESTINATION_TOPIC = "simple.topic"; //? name of the topic

    @Autowired //? injects the JmsTemplate
    private JmsTemplate jmsTemplate;

    //? sends a message to the topic
    public void sendMessage(String message) {
        jmsTemplate.convertAndSend(DESTINATION_TOPIC, message); //? sends the message to the topic
    }

}
