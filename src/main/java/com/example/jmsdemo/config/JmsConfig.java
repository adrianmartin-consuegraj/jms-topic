package com.example.jmsdemo.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration //? indicates that this class contains Spring configuration.
@EnableJms //? enables JMS listeners in the application.
public class JmsConfig {

    private static final String BROKER_URL = "tcp://localhost:61616"; //? the url where the ActiveMQ broker is running

    @Bean //? defines a bean for the ActiveMQ connection factory
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(BROKER_URL); //? sets the broker URL
        return connectionFactory;
    }

    @Bean //? creates a JmsTemplate bean for sending messages
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate(connectionFactory());
        template.setPubSubDomain(true); //? sets the JmsTemplate to use topics instead of queues
        return template;
    }

    @Bean //? configures the listener container factory for topics
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory()); //? configures the connection factory
        factory.setPubSubDomain(true); //? enables the use of topics
        return factory;
    }
}
