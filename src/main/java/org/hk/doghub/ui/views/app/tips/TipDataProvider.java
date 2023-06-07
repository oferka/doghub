package org.hk.doghub.ui.views.app.tips;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.List;

public interface TipDataProvider extends EntityDataProvider<DogHubTip> {

    List<DogHubTip> findAllForUser(@NotNull AuthenticatedUser authenticatedUser);

    long countForUser(@NotNull AuthenticatedUser authenticatedUser);

    boolean hasAccess(@NotNull AuthenticatedUser authenticatedUser, @NotNull Long urlId);
}
