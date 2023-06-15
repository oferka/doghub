package org.hk.doghub.data.content.generator.user.faker;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.user.User;
import org.hk.doghub.data.content.generator.user.faker.MobileNumberProvider;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class MobileNumberProviderTest {

    @Autowired
    private MobileNumberProvider mobileNumberProvider;

    @RepeatedTest(10)
    public void shouldGenerate() {
        User user = new User();
        String mobileNumber = mobileNumberProvider.get(user);
        log.info(mobileNumber);
        assertNotNull(mobileNumber);
    }
}