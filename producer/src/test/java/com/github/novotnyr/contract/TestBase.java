package com.github.novotnyr.contract;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMessageVerifier
public abstract class TestBase {
    @Autowired Application application;

    protected void onUserIsOnline() {
        application.sendNotification();
    }
}
