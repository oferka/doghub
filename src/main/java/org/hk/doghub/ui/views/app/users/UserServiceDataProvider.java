package org.hk.doghub.ui.views.app.users;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.service.user.DogHubUserService;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Profile({"users-service-data-provider", "default"})
public class UserServiceDataProvider implements UserDataProvider {

    private final DogHubUserService dogHubUserService;

    @Override
    public long count() {
        return dogHubUserService.count();
    }

    @Override
    public @NotNull List<DogHubUser> findAll() {
        return dogHubUserService.findAll();
    }

    @Override
    public @NotNull Optional<DogHubUser> findById(@NotNull Long id) {
        return dogHubUserService.findById(id);
    }

    @Override
    public @NotNull Optional<DogHubUser> findNext(@NotNull AuthenticatedUser authenticatedUser, @NotNull Long id) {
        return dogHubUserService.findNext(id);
    }

    @Override
    public @NotNull Optional<DogHubUser> findPrevious(@NotNull AuthenticatedUser authenticatedUser, @NotNull Long id) {
        return dogHubUserService.findPrevious(id);
    }
}
