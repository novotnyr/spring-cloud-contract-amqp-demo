package com.github.novotnyr.contract;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"com.github.novotnyr:spring-cloud-contract-amqp-producer:+"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ListenerTest {
    @Autowired
    StubTrigger stubTrigger;

    @Autowired
    UserPresenceListener userPresenceListener;

    @Test
    public void shouldReceiveNotification() {
        stubTrigger.trigger("user-goes-online");

        assertTrue(this.userPresenceListener.getAvailableUsers().size() > 0);
    }
}
