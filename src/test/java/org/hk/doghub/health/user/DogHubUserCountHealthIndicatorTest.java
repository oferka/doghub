package org.hk.doghub.health.user;

import org.hk.doghub.health.EntityCountHealthIndicator;
import org.hk.doghub.model.user.DogHubUser;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.springframework.boot.actuate.health.Status.UP;

@SpringBootTest
class DogHubUserCountHealthIndicatorTest {

    @Autowired
    private EntityCountHealthIndicator<DogHubUser> indicator;

    @RepeatedTest(3)
    void shouldLoad() {
        Health health = indicator.health();
        assertSame(health.getStatus(), UP);
    }
}