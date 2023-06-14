package org.hk.doghub.data.content.provider;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.data.content.generator.GeneratorService;
import org.hk.doghub.data.content.generator.ProvidedObject;
import org.hk.doghub.model.AbstractEntity;

import java.util.List;

public abstract class AbstractEntityProvider <P extends ProvidedObject, T extends AbstractEntity> implements EntityProvider<T> {

    public @NotNull T get() {
        return getConverter().convert(getGeneratorService().generate());
    }

    public @NotNull List<T> get(int numberOfItems) {
        return getConverter().convert(getGeneratorService().generate(numberOfItems));
    }

    protected abstract GeneratorService<P> getGeneratorService();

    protected abstract Converter<P, T> getConverter();
}
