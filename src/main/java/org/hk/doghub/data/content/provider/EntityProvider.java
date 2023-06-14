package org.hk.doghub.data.content.provider;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.AbstractEntity;

import java.util.List;

public interface EntityProvider<T extends AbstractEntity> {

    @NotNull T get();

    @NotNull List<T> get(int numberOfItems);
}
