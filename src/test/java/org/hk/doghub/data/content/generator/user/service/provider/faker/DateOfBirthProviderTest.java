package org.hk.doghub.data.content.generator.user.service.provider.faker;

import org.hk.doghub.data.content.generator.user.model.User;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DateOfBirthProviderTest {

    @Autowired
    private DateOfBirthProvider dateOfBirthProvider;

    @RepeatedTest(10)
    public void shouldGenerate() {
        User user = new User();
        ZonedDateTime dateOfBirth = dateOfBirthProvider.get(user);
        assertNotNull(dateOfBirth);
    }
}