package org.hk.doghub.ui.views.app.tips;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.List;
import java.util.Optional;

public interface TipDataProvider extends EntityDataProvider<DogHubTip> {

    Optional<DogHubTip> findNext(@NotNull AuthenticatedUser authenticatedUser, @NotNull Long urlId);

    Optional<DogHubTip> findPrevious(@NotNull AuthenticatedUser authenticatedUser, @NotNull Long urlId);

    List<DogHubTip> findAllForUser(@NotNull AuthenticatedUser authenticatedUser);

    long countForUser(@NotNull AuthenticatedUser authenticatedUser);

    boolean hasAccess(@NotNull AuthenticatedUser authenticatedUser, @NotNull Long urlId);
}
