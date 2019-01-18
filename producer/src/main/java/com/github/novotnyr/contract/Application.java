package com.github.novotnyr.contract;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendNotification() {
        amqpTemplate.convertAndSend("user-presence", "" , new Notification("amadeus"));
    }

    @Bean
    public MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
