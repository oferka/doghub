package org.hk.doghub.data.content.generator.user.service.provider.faker;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.user.Address;
import org.hk.doghub.data.content.generator.user.faker.HouseNumberProvider;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class HouseNumberProviderTest {

    @Autowired
    private HouseNumberProvider houseNumberProvider;

    @RepeatedTest(10)
    public void shouldGenerate() {
        Address address = new Address();
        int houseNumber = houseNumberProvider.get(address);
        log.info(Integer.toString(houseNumber));
    }
}