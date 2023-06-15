package org.hk.doghub.data.content.generator.user.faker;

import org.hk.doghub.data.content.generator.user.User;
import org.hk.doghub.data.content.generator.user.faker.PasswordProvider;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PasswordProviderTest {

    @Autowired
    private PasswordProvider passwordProvider;

    @RepeatedTest(10)
    public void shouldGenerate() {
        User user = new User();
        String password = passwordProvider.get(user);
        assertNotNull(password);
    }
}