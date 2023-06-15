package org.hk.doghub.data.content.generator.user.faker;

import org.hk.doghub.data.content.generator.user.User;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ThumbnailPictureProviderTest {

    @Autowired
    private ThumbnailPictureProvider provider;

    @RepeatedTest(10)
    public void shouldGet() {
        String value = provider.get(new User());
        assertNotNull(value);
    }
}