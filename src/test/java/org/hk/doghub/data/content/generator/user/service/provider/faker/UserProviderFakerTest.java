package org.hk.doghub.data.content.generator.user.service.provider.faker;

import org.hk.doghub.data.content.generator.user.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserProviderFakerTest {

    @Autowired
    private UserProviderFaker userProvider;

    @Test
    public void shouldGenerate() {
        User user = userProvider.generate();
        assertNotNull(user);
    }

    @Test
    public void shouldGenerateMultiple() {
        List<User> users = userProvider.generate(10);
        assertEquals(10, users.size());
    }
}