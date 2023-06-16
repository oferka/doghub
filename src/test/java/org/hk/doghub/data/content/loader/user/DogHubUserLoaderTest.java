package org.hk.doghub.data.content.loader.user;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.loader.AbstractEntityLoader;
import org.hk.doghub.model.user.DogHubUser;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static java.text.MessageFormat.format;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
class DogHubUserLoaderTest {

    @Autowired
    private AbstractEntityLoader<DogHubUser> loader;

    @RepeatedTest(10)
    void shouldLoad() {
        long loadedCounter = loader.load();
        assertTrue(loadedCounter > 0);
        log.info(format("{0} entities loaded", loadedCounter));
    }
}
