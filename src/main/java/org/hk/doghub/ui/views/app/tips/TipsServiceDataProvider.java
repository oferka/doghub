package org.hk.doghub.ui.views.app.tips;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.service.tip.DogHubTipService;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
@Profile({"tips-service-data-provider", "default"})
public class TipsServiceDataProvider implements TipsDataProvider {

    private final DogHubTipService dogHubTipService;

    @Override
    public long count() {
        return dogHubTipService.count();
    }

    @Override
    public @NotNull List<DogHubTip> findAll() {
        return dogHubTipService.findAll();
    }

    @Override
    public @NotNull Optional<DogHubTip> findById(@NotNull Long id) {
        return dogHubTipService.findById(id);
    }

    @Override
    public List<DogHubTip> findAllForUser(@NotNull AuthenticatedUser authenticatedUser) {
        List<DogHubTip> result = emptyList();
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
    public boolean hasAccess(@NotNull AuthenticatedUser authenticatedUser, @NotNull Long urlId) {
        boolean result = false;
        if(authenticatedUser.hasAdminRole()) {
            result = true;
        }
        else {
            if(authenticatedUser.hasUserRole()) {
                result = existsByIdAndCreatedBy(urlId, authenticatedUser.get().get());
            }
        }
        return result;
    }

    private boolean existsByIdAndCreatedBy(@NotNull Long id, @NotNull DogHubUser user) {
        return dogHubTipService.existsByIdAndCreatedBy(id, user);
    }

    private long countByCreatedBy(@NotNull DogHubUser user) {
        return dogHubTipService .countByCreatedBy(user);
    }

    private List<DogHubTip> findByCreatedBy(@NotNull DogHubUser user) {
        return dogHubTipService.findByCreatedBy(user);
    }
}
