package org.hk.doghub.data.content.generator;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static org.hk.doghub.data.content.generator.Provider.MAX_NUMBER_OF_ITEMS;
import static org.hk.doghub.data.content.generator.Provider.MIN_NUMBER_OF_ITEMS;

@Service
@Validated
public abstract class GeneratorService<T extends ProvidedObject> {

    public List<T> generate(@Min(MIN_NUMBER_OF_ITEMS) @Max(MAX_NUMBER_OF_ITEMS) int numberOfUsers) {
        return getProvider().get(numberOfUsers);
    }

    public T generate() {
        return getProvider().get();
    }

    protected abstract Provider<T> getProvider();
}
