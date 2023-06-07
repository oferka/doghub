package org.hk.doghub.ui.views.app;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.AbstractEntity;
import org.hk.doghub.security.AuthenticatedUser;

import java.util.List;
import java.util.Optional;

public interface EntityDataProvider<T extends AbstractEntity> {

    long count();

    @NotNull
    List<T> findAll();

    @NotNull
    Optional<T> findById(@NotNull Long id);

    Optional<T> findNext(@NotNull AuthenticatedUser authenticatedUser, @NotNull Long urlId);

    Optional<T> findPrevious(@NotNull AuthenticatedUser authenticatedUser, @NotNull Long urlId);
}
