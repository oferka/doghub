package org.hk.doghub.ui.views.app.dogs;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.List;

public interface DogDataProvider extends EntityDataProvider<DogHubDog> {

    List<DogHubDog> findAllForUser(@NotNull AuthenticatedUser authenticatedUser);

    long countForUser(@NotNull AuthenticatedUser authenticatedUser);

    boolean hasAccess(@NotNull AuthenticatedUser authenticatedUser, @NotNull Long urlId);
}
