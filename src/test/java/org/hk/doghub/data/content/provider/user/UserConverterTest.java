package org.hk.doghub.data.content.provider.user;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.Provider;
import org.hk.doghub.data.content.generator.user.User;
import org.hk.doghub.data.content.provider.Converter;
import org.hk.doghub.model.user.DogHubUser;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class UserConverterTest {

    @Autowired
    private Converter<User, DogHubUser> converter;

    @Autowired
    private Provider<User> provider;

    @RepeatedTest(10)
    void shouldConvert() {
        User providedObject = provider.get();
        DogHubUser entity = converter.convert(providedObject);
        assertNotNull(entity);
        log.info(entity.toString());
    }

    @RepeatedTest(10)
    void shouldConvertMultiple() {
        List<User> providedObjects = provider.get(5);
        List<DogHubUser> entities = converter.convert(providedObjects);
        assertEquals(5, entities.size());
    }
}
