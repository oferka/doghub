package org.hk.doghub.data.content.generator;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hk.doghub.data.content.generator.user.model.User;

import java.util.List;

public interface EntityProvider<T extends ProvidedObject> {

    int MIN_NUMBER_OF_ITEMS = 1;

    int MAX_NUMBER_OF_ITEMS = 999;

    List<T> get(@Min(MIN_NUMBER_OF_ITEMS) @Max(MAX_NUMBER_OF_ITEMS) int numberOfItems);

    T get();
}
