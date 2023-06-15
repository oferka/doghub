package org.hk.doghub.data.content.generator.user.faker;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.user.Address;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class HouseNumberProviderTest {

    @Autowired
    private HouseNumberProvider provider;

    @RepeatedTest(10)
    public void shouldGet() {
        int value = provider.get(new Address());
        log.info(Integer.toString(value));
    }
}