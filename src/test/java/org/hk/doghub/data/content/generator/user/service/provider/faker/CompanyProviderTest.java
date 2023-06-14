package org.hk.doghub.data.content.generator.user.service.provider.faker;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.user.User;
import org.hk.doghub.data.content.generator.user.faker.CompanyProvider;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class CompanyProviderTest {

    @Autowired
    private CompanyProvider companyProvider;

    @RepeatedTest(10)
    public void shouldGenerate() {
        User user = new User();
        String company = companyProvider.get(user);
        log.info(company);
        assertNotNull(company);
    }
}