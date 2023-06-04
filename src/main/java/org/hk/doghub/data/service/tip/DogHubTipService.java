package org.hk.doghub.data.service.tip;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.repository.tip.DogHubTipRepository;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DogHubTipService {

    private final DogHubTipRepository repository;

    public Optional<DogHubTip> findById(@NotNull Long id) {
        return repository.findById(id);
    }

    public DogHubTip save(@NotNull DogHubTip entity) {
        return repository.save(entity);
    }

    public Iterable<DogHubTip> saveAll(@NotNull Iterable<DogHubTip> entities) {
        return repository.saveAll(entities);
    }

    public void deleteById(@NotNull Long id) {
        repository.deleteById(id);
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

    public int count() {
        return (int)repository.count();
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

    public Optional<DogHubTip> findPrevious(long selectedTipId, DogHubUser user) {
        return Optional.empty();
    }

    public Optional<DogHubTip> findNext(long selectedTipId, DogHubUser user) {
        return Optional.empty();
    }
}
