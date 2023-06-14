package org.hk.doghub.data.content.generator.user.service.provider.randomme;

import org.hk.doghub.data.content.generator.user.User;
import org.hk.doghub.data.content.generator.user.randomme.RandomMeClient;
import org.hk.doghub.data.content.generator.user.randomme.RandomMeResponseConverter;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RandomMeResponseConverterTest {

    @Autowired
    private RandomMeResponseConverter randomMeResponseConverter;

    @Autowired
    private RandomMeClient randomMeClient;

    @RepeatedTest(10)
    public void shouldConvertToUsers() {
        List<User> users = randomMeResponseConverter.convertToUsers(randomMeClient.get(20));
        assertEquals(20, users.size());
    }
}