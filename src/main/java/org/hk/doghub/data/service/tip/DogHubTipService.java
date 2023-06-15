package org.hk.doghub.data.service.tip;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.repository.EntityRepository;
import org.hk.doghub.data.repository.tip.DogHubTipRepository;
import org.hk.doghub.data.service.AbstractEntityService;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DogHubTipService extends AbstractEntityService<DogHubTip> {

    private final DogHubTipRepository repository;

    @Override
    protected EntityRepository<DogHubTip> getEntityRepository() {
        return repository;
    }

    @Override
    public boolean exists(@NotNull DogHubTip entity) {
        return existsByIdAndCreatedBy(entity.getId(), entity.getCreatedBy());
    }

    public Optional<DogHubTip> findPrevious(@NotNull Long id) {
        return repository.findTop1ByIdLessThanOrderByIdDesc(id);
    }

    public Optional<DogHubTip> findNext(@NotNull Long id) {
        return repository.findTop1ByIdGreaterThanOrderById(id);
    }

    public List<DogHubTip> findByCreatedBy(@NotNull DogHubUser user) {
        return repository.findByCreatedBy(user);
    }

    public long countByCreatedBy(@NotNull DogHubUser user) {
        return repository.countByCreatedBy(user);
    }

    public boolean existsByIdAndCreatedBy(@NotNull Long id, @NotNull DogHubUser user) {
        return repository.existsByIdAndCreatedBy(id, user);
    }

    public boolean existsByTitleAndCreatedBy(@NotNull String title, @NotNull DogHubUser user) {
        return repository.existsByTitleAndCreatedBy(title, user);
    }

    public Optional<DogHubTip> findPreviousByCreatedBy(@NotNull Long id, @NotNull DogHubUser user) {
        return repository.findTop1ByIdLessThanAndCreatedByOrderByIdDesc(id, user);
    }

    public Optional<DogHubTip> findNextByCreatedBy(@NotNull Long id, @NotNull DogHubUser user) {
        return repository.findTop1ByIdGreaterThanAndCreatedByOrderById(id, user);
    }
}
