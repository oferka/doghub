package org.hk.doghub.data.content.generator.user.service.provider.randomme;

import org.hk.doghub.data.content.generator.user.model.User;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RandomMeResponseConverterTest {

    @Autowired
    private RandomMeResponseConverter randomMeResponseConverter;

    @Autowired
    private RandomMeClient randomMeClient;

    @RepeatedTest(10)
    public void shouldConvertToUser() {
        User user = randomMeResponseConverter.convertToUser(randomMeClient.get());
        assertNotNull(user);
    }

    @RepeatedTest(10)
    public void shouldConvertToUsers() {
        List<User> users = randomMeResponseConverter.convertToUsers(randomMeClient.get(20));
        assertEquals(20, users.size());
    }
}