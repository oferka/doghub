package org.hk.doghub.data.content.generator.dog.faker;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.dog.Dog;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class DogBreedProviderTest {

    @Autowired
    private DogBreedProvider provider;

    @Autowired
    private DogThumbnailPictureProvider thumbnailPictureProvider;

    @RepeatedTest(10)
    public void shouldGet() {
        Dog dog = new Dog();
        dog.setThumbnailPicture(thumbnailPictureProvider.get(dog));
        String value = provider.get(dog);
        log.info(value);
        assertNotNull(value);
    }
}
