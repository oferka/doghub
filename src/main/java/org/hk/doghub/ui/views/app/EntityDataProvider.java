package org.hk.doghub.ui.views.app;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.AbstractEntity;

import java.util.List;
import java.util.Optional;

public interface EntityDataProvider<T extends AbstractEntity> {

    long count();

    @NotNull
    List<T> findAll();

    @NotNull
    Optional<T> findById(@NotNull Long id);
}
