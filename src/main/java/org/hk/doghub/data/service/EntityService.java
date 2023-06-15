package org.hk.doghub.data.service;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.AbstractEntity;

public interface EntityService<T extends AbstractEntity> {

    T save(@NotNull T entity);
}
