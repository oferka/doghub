package org.hk.doghub.data.service.tip;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.hk.doghub.data.repository.tip.DogHubTipRepository;
import org.hk.doghub.data.service.EntityService;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DogHubTipService implements EntityService<DogHubTip> {

    private final DogHubTipRepository repository;

    public Optional<DogHubTip> findById(@NotNull Long id) {
        return repository.findById(id);
    }

    public List<DogHubTip> findAll() {
        return repository.findAll();
    }

    public Page<DogHubTip> findAll(@NotNull Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<DogHubTip> findAll(@NotNull Pageable pageable, @NotNull Specification<DogHubTip> filter) {
        return repository.findAll(filter, pageable);
    }

    public DogHubTip save(@NotNull DogHubTip entity) {
        return repository.save(entity);
    }

    public int count() {
        return (int)repository.count();
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

    public Optional<DogHubTip> findRandom() {
        long count = repository.count();
        Page<DogHubTip> page = repository.findAll(PageRequest.of(RandomUtils.nextInt(0, (int)count), 1, Sort.by(Sort.Direction.ASC, "id")));
        if(page.iterator().hasNext()) {
            return Optional.of(page.iterator().next());
        }
        return Optional.empty();
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
