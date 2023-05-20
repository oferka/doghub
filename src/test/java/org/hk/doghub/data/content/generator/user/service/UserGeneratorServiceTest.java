package org.hk.doghub.data.content.generator.user.service;

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
class UserGeneratorServiceTest {

    @Autowired
    private UserGeneratorService userGeneratorService;

    @RepeatedTest(10)
    void shouldGenerate() {
        User user = userGeneratorService.generate();
        assertNotNull(user);
        log.info(user.toString());
    }

    @RepeatedTest(10)
    public void shouldGenerateMultiple() {
        List<User> users = userGeneratorService.generate(5);
        assertEquals(5, users.size());
    }
}