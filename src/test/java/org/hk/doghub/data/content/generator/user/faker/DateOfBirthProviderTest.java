package org.hk.doghub.data.content.generator.user.faker;

import org.hk.doghub.data.content.generator.user.User;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DateOfBirthProviderTest {

    @Autowired
    private DateOfBirthProvider provider;

    @RepeatedTest(10)
    public void shouldGet() {
        ZonedDateTime value = provider.get(new User());
        assertNotNull(value);
    }
}