package org.hk.doghub.data.content.generator.user;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.Provider;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class UserProviderTest {

    @Autowired
    private Provider<User> provider;

    @RepeatedTest(10)
    void shouldGet() {
        User entity = provider.get();
        assertNotNull(entity);
        log.info(entity.toString());
    }

    @RepeatedTest(10)
    public void shouldGetMultiple() {
        List<User> entities = provider.get(5);
        assertEquals(5, entities.size());
    }
}