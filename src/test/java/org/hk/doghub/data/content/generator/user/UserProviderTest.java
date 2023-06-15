package org.hk.doghub.data.content.generator.user;

import lombok.extern.slf4j.Slf4j;
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
    private UserProvider userProvider;

    @RepeatedTest(10)
    void shouldGet() {
        User user = userProvider.get();
        assertNotNull(user);
        log.info(user.toString());
    }

    @RepeatedTest(10)
    public void shouldGetMultiple() {
        List<User> users = userProvider.get(5);
        assertEquals(5, users.size());
    }
}