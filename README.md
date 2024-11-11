# JMS Topic Demo

This project is a simple demonstration of how to use Java Message Service (JMS) with topics. It showcases a basic implementation for sending and receiving messages using the subscribe-publish messaging model.

## Overview
The goal of this demo is to help developers get familiar with setting up and using JMS with topics, which allows multiple subscribers to receive messages broadcasted by a publisher.

## Features
- Demonstrates the basic configuration of a JMS provider.
- Shows how to create a topic publisher and subscriber.
- Provides example code for sending and receiving messages.

## Getting Started

1. **Clone the repository:**
   ```script
   git clone https://github.com/yourusername/jms-topic-demo.git
   ./bin/activemq start
2. **Run Spring Boot:**
   ```script
   mvn spring-boot:run
3. **Run ActiveMQ:**
   ```script
   ./bin/activemq start
4. **Run Postman:**
   ```script
   http://localhost:8080/api/send
and send a message in the body like "Hello, this is working!" -> you'll received the message in the Terminal of your IDE.

   
