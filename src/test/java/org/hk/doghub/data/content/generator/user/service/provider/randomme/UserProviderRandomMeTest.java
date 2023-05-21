package org.hk.doghub.data.content.generator.user.service.provider.randomme;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.user.model.User;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class UserProviderRandomMeTest {

    @Autowired
    private UserProviderRandomMe userProvider;

    @RepeatedTest(10)
    public void shouldGenerate() {
        User user = userProvider.generate();
        assertNotNull(user);
    }

    @RepeatedTest(10)
    public void shouldGenerateMultiple() {
        List<User> users = userProvider.generate(50);
        assertEquals(50, users.size());
    }
}