package org.hk.doghub.data.content.loader.dog;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.loader.AbstractEntityLoader;
import org.hk.doghub.model.dog.DogHubDog;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static java.text.MessageFormat.format;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
class DogHubDogLoaderTest {

    @Autowired
    private AbstractEntityLoader<DogHubDog> loader;

    @RepeatedTest(3)
    void shouldLoad() {
        long loadedCounter = loader.load();
        assertTrue(loadedCounter > 0);
        log.info(format("{0} entities loaded", loadedCounter));
    }
}
