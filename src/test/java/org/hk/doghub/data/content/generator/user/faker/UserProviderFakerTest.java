package org.hk.doghub.data.content.generator.user.faker;

import org.hk.doghub.data.content.generator.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserProviderFakerTest {

    @Autowired
    private UserProviderFaker provider;

    @Test
    public void shouldGet() {
        User entity = provider.get();
        assertNotNull(entity);
    }

    @Test
    public void shouldGetMultiple() {
        List<User> entities = provider.get(10);
        assertEquals(10, entities.size());
    }
}