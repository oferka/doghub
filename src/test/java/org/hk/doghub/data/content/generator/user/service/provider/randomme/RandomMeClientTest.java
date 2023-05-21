package org.hk.doghub.data.content.generator.user.service.provider.randomme;

import org.hk.doghub.data.content.generator.user.service.provider.randomme.response.RandomMeResponse;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RandomMeClientTest {

    @Autowired
    private RandomMeClient randomMeClient;

    @RepeatedTest(10)
    public void shouldGetMultiple() {
        RandomMeResponse randomMeResponse = randomMeClient.get(20);
        assertNotNull(randomMeResponse);
    }
}