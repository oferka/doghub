package org.hk.doghub;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class DogHubApplicationTest {

    @Test
    void shouldLoadContext() {
        log.info("Context loaded");
    }
}