package org.hk.doghub.data.content.provider;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.data.content.generator.ProvidedObject;
import org.hk.doghub.model.AbstractEntity;

import java.util.List;

public interface Converter<P extends ProvidedObject, T extends AbstractEntity> {

    T convert(@NotNull P providedObject);

    List<T> convert(List<P> providedObjects);
}
