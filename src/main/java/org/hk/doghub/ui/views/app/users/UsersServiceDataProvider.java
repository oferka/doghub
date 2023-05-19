package org.hk.doghub.ui.views.app.users;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.service.DogHubUserService;
import org.hk.doghub.model.DogHubUser;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Profile({"users-service-data-provider", "default"})
public class UsersServiceDataProvider implements UsersDataProvider {

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
}
