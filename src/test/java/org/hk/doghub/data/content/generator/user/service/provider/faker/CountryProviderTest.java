package org.hk.doghub.data.content.generator.user.service.provider.faker;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.user.model.Address;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class CountryProviderTest {

    @Autowired
    private CountryProvider countryProvider;

    @RepeatedTest(10)
    public void shouldGenerate() {
        Address address = new Address();
        String country = countryProvider.get(address);
        log.info(country);
        assertNotNull(country);
    }
}