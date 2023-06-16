package org.hk.doghub.data.content.provider.dog;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.Provider;
import org.hk.doghub.data.content.generator.dog.Dog;
import org.hk.doghub.data.content.provider.Converter;
import org.hk.doghub.model.dog.DogHubDog;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class DogConverterTest {

    @Autowired
    private Converter<Dog, DogHubDog> converter;

    @Autowired
    private Provider<Dog> provider;

    @RepeatedTest(10)
    void shouldConvert() {
        Dog providedObject = provider.get();
        DogHubDog entity = converter.convert(providedObject);
        assertNotNull(entity);
        log.info(entity.toString());
    }

    @RepeatedTest(10)
    void shouldConvertMultiple() {
        List<Dog> providedObjects = provider.get(5);
        List<DogHubDog> entities = converter.convert(providedObjects);
        assertEquals(5, entities.size());
    }
}