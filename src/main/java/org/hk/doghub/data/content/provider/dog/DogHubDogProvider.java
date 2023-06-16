package org.hk.doghub.data.content.provider.dog;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.GeneratorService;
import org.hk.doghub.data.content.generator.dog.Dog;
import org.hk.doghub.data.content.provider.AbstractEntityProvider;
import org.hk.doghub.data.content.provider.Converter;
import org.hk.doghub.model.dog.DogHubDog;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogHubDogProvider extends AbstractEntityProvider<Dog, DogHubDog> {

    private final GeneratorService<Dog> generatorService;

    private final Converter<Dog, DogHubDog> converter;

    @Override
    protected GeneratorService<Dog> getGeneratorService() {
        return generatorService;
    }

    @Override
    protected Converter<Dog, DogHubDog> getConverter() {
        return converter;
    }
}
