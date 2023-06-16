package org.hk.doghub.data.content.generator.dog;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.content.generator.GeneratorService;
import org.hk.doghub.data.content.generator.Provider;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class DogGeneratorService extends GeneratorService<Dog> {

    private final Provider<Dog> provider;

    @Override
    protected @NotNull Provider<Dog> getProvider() {
        return provider;
    }
}
