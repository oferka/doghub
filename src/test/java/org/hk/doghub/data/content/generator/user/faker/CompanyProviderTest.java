package org.hk.doghub.data.content.generator.user.faker;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.user.User;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class CompanyProviderTest {

    @Autowired
    private CompanyProvider provider;

    @RepeatedTest(10)
    public void shouldGet() {
        String value = provider.get(new User());
        log.info(value);
        assertNotNull(value);
    }
}