package org.hk.doghub.automation.e2e.selenium.execution;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DateTimeTakerTest {

    @Autowired
    private DateTimeTaker dateTimeTaker;

    @Test
    public void shouldTake() {
        LocalDateTime time = dateTimeTaker.take();
        assertNotNull(time);
    }
}