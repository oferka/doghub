package org.hk.doghub.data.content.provider.dog;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.dog.Dog;
import org.hk.doghub.data.content.provider.AbstractEntityProvider;
import org.hk.doghub.model.dog.DogHubDog;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class DogHubDogProviderTest {

    @Autowired
    private AbstractEntityProvider<Dog, DogHubDog> provider;

    @RepeatedTest(10)
    void shouldConvert() {
        DogHubDog entity = provider.get();
        assertNotNull(entity);
        log.info(entity.toString());
    }

    @RepeatedTest(10)
    void shouldConvertMultiple() {
        List<DogHubDog> entities = provider.get(5);
        assertEquals(5, entities.size());
    }
}