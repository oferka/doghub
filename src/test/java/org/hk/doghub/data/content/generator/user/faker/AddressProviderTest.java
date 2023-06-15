package org.hk.doghub.data.content.generator.user.faker;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.user.Address;
import org.hk.doghub.data.content.generator.user.User;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class AddressProviderTest {

    @Autowired
    private AddressProvider addressProvider;

    @RepeatedTest(10)
    public void shouldGenerate() {
        User user = new User();
        Address address = addressProvider.get(user);
        log.info(address.toString());
        assertNotNull(address);
    }
}