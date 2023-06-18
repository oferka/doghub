package org.hk.doghub.ui.views.app;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.HasCreatedBy;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.security.AuthenticatedUser;

import java.util.List;

public interface CreatedByEntityDataProvider<T extends NamedEntity & HasCreatedBy> extends EntityDataProvider<T> {

    @NotNull List<T> findAllForUser(@NotNull AuthenticatedUser authenticatedUser);

    long countForUser(@NotNull AuthenticatedUser authenticatedUser);

    boolean hasAccess(@NotNull AuthenticatedUser authenticatedUser, @NotNull Long urlId);
}
