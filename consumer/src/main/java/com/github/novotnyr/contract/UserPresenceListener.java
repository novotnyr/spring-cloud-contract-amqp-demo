package com.github.novotnyr.contract;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserPresenceListener {
    private List<String> availableUsers = new ArrayList<>();

    @RabbitListener(queues = "user-presence")
    public void handle(UserGoesOnlineMessage userGoesOnlineMessage) {
        this.availableUsers.add(userGoesOnlineMessage.getUser());
    }

    public List<String> getAvailableUsers() {
        return availableUsers;
    }
}
