package org.hk.doghub.ui.views.app.users;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

import java.util.List;
import java.util.Optional;

public interface UsersDataProvider {

    long count();

    @NotNull
    List<DogHubUser> findAll();

    @NotNull
    Optional<DogHubUser> findById(@NotNull Long id);

    @NotNull
    Optional<DogHubUser> findNext(Long id);

    @NotNull
    Optional<DogHubUser> findPrevious(Long id);
}
