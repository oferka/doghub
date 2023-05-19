package org.hk.doghub.data.service;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.repository.DogHubTipRepository;
import org.hk.doghub.model.DogHubTip;
import org.hk.doghub.model.DogHubUser;
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

    public boolean exists(@NotNull DogHubTip url) {
        return repository.existsByValue(url.getValue());
    }

    public Optional<DogHubTip> findByValue(@NotNull String value) {
        return repository.findByValue(value);
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
}
