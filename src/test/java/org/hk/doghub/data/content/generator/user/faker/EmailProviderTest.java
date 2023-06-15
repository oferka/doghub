package org.hk.doghub.data.content.generator.user.faker;

import org.hk.doghub.data.content.generator.user.User;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EmailProviderTest {

    @Autowired
    private EmailProvider emailProvider;

    @Autowired
    private FirstNameProvider firstNameProvider;

    @Autowired
    private LastNameProvider lastNameProvider;

    @RepeatedTest(10)
    public void shouldGet() {
        User user = new User();
        user.setFirstName(firstNameProvider.get(user));
        user.setLastName(lastNameProvider.get(user));
        String email = emailProvider.get(user);
        System.out.println(email);
        assertNotNull(email);
    }
}