package org.hk.doghub.ui.views.app.users;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.Optional;

public interface UserDataProvider extends EntityDataProvider<DogHubUser> {

    @NotNull
    Optional<DogHubUser> findNext(Long id);

    @NotNull
    Optional<DogHubUser> findPrevious(Long id);
}
