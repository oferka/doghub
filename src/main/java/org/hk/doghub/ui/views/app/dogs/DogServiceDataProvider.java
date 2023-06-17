package org.hk.doghub.ui.views.app.dogs;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.service.dog.DogHubDogService;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
@Profile({"dogs-service-data-provider", "default"})
public class DogServiceDataProvider implements DogDataProvider {

    private final DogHubDogService dogHubDogService;

    @Override
    public long count() {
        return dogHubDogService.count();
    }

    @Override
    public @NotNull List<DogHubDog> findAll() {
        return dogHubDogService.findAll();
    }

    @Override
    public @NotNull Optional<DogHubDog> findById(@NotNull Long id) {
        return dogHubDogService.findById(id);
    }

    @Override
    public List<DogHubDog> findAllForUser(@NotNull AuthenticatedUser authenticatedUser) {
        List<DogHubDog> result = emptyList();
        if(authenticatedUser.hasAdminRole()) {
            result = findAll();
        }
        else {
            if(authenticatedUser.hasUserRole()) {
                result = findByCreatedBy(authenticatedUser.get().get());
            }
        }
        return result;
    }

    @Override
    public long countForUser(@NotNull AuthenticatedUser authenticatedUser) {
        long result = 0;
        if(authenticatedUser.hasAdminRole()) {
            result = count();
        }
        else {
            if(authenticatedUser.hasUserRole()) {
                result = countByCreatedBy(authenticatedUser.get().get());
            }
        }
        return result;
    }

    @Override
    public boolean hasAccess(@NotNull AuthenticatedUser authenticatedUser, @NotNull Long tipId) {
        boolean result = false;
        if(authenticatedUser.hasAdminRole()) {
            result = true;
        }
        else {
            if(authenticatedUser.hasUserRole()) {
                result = existsByIdAndCreatedBy(tipId, authenticatedUser.get().get());
            }
        }
        return result;
    }

    @Override
    public Optional<DogHubDog> findPrevious(@NotNull AuthenticatedUser authenticatedUser, @NotNull Long id) {
        Optional<DogHubDog> result = Optional.empty();
        if(authenticatedUser.hasAdminRole()) {
            result = dogHubDogService.findPrevious(id);
        }
        else {
            Optional<DogHubUser> userOptional = authenticatedUser.get();
            if(userOptional.isPresent()) {
                return dogHubDogService.findPreviousByCreatedBy(id, userOptional.get());
            }
        }
        return result;
    }

    @Override
    public Optional<DogHubDog> findNext(@NotNull AuthenticatedUser authenticatedUser, @NotNull Long id) {
        Optional<DogHubDog> result = Optional.empty();
        if(authenticatedUser.hasAdminRole()) {
            result = dogHubDogService.findNext(id);
        }
        else {
            Optional<DogHubUser> userOptional = authenticatedUser.get();
            if(userOptional.isPresent()) {
                return dogHubDogService.findNextByCreatedBy(id, userOptional.get());
            }
        }
        return result;
    }

    private boolean existsByIdAndCreatedBy(@NotNull Long id, @NotNull DogHubUser user) {
        return dogHubDogService.existsByIdAndCreatedBy(id, user);
    }

    private long countByCreatedBy(@NotNull DogHubUser user) {
        return dogHubDogService.countByCreatedBy(user);
    }

    private List<DogHubDog> findByCreatedBy(@NotNull DogHubUser user) {
        return dogHubDogService.findByCreatedBy(user);
    }
}
