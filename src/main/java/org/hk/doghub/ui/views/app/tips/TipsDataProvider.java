package org.hk.doghub.ui.views.app.tips;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;

import java.util.List;
import java.util.Optional;

public interface TipsDataProvider {

    long count();

    @NotNull
    List<DogHubTip> findAll();

    @NotNull
    Optional<DogHubTip> findById(@NotNull Long id);

    List<DogHubTip> findAllForUser(@NotNull AuthenticatedUser authenticatedUser);

    long countForUser(@NotNull AuthenticatedUser authenticatedUser);

    boolean hasAccess(@NotNull AuthenticatedUser authenticatedUser, @NotNull Long urlId);
}
