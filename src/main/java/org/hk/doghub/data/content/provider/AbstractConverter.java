package org.hk.doghub.data.content.provider;

import org.hk.doghub.data.content.generator.ProvidedObject;
import org.hk.doghub.model.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverter<P extends ProvidedObject, T extends AbstractEntity> implements Converter<P, T> {

    @Override
    public List<T> convert(List<P> providedObjects) {
        List<T> result =  new ArrayList<>();
        for(P providedObject : providedObjects) {
            result.add(convert(providedObject));
        }
        return result;
    }
}
