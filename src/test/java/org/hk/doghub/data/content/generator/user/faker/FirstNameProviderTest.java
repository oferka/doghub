package org.hk.doghub.data.content.generator.user.faker;

import org.hk.doghub.data.content.generator.user.User;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class FirstNameProviderTest {

    @Autowired
    private FirstNameProvider firstNameProvider;

    @RepeatedTest(10)
    public void shouldGenerate() {
        User user = new User();
        String firstName = firstNameProvider.get(user);
        assertNotNull(firstName);
    }
}