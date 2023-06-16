package org.hk.doghub.data.content.generator.dog.faker;

import org.hk.doghub.data.content.generator.dog.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DogProviderFakerTest {

    @Autowired
    private DogProviderFaker provider;

    @Test
    public void shouldGet() {
        Dog entity = provider.get();
        assertNotNull(entity);
    }

    @Test
    public void shouldGetMultiple() {
        List<Dog> entities = provider.get(10);
        assertEquals(10, entities.size());
    }
}