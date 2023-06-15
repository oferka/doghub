package org.hk.doghub.data.service.user;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.hk.doghub.data.repository.user.DogHubUserRepository;
import org.hk.doghub.data.service.EntityService;
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
public class DogHubUserService implements EntityService<DogHubUser> {

    private final DogHubUserRepository repository;

    public Optional<DogHubUser> findById(@NotNull Long id) {
        return repository.findById(id);
    }

    public List<DogHubUser> findAll() {
        return repository.findAll();
    }

    public Page<DogHubUser> findAll(@NotNull Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<DogHubUser> findAll(@NotNull Pageable pageable, @NotNull Specification<DogHubUser> filter) {
        return repository.findAll(filter, pageable);
    }

    public DogHubUser save(@NotNull DogHubUser entity) {
        return repository.save(entity);
    }

    public int count() {
        return (int)repository.count();
    }

    public boolean exists(@NotNull DogHubUser user) {
        return repository.existsByUsername(user.getUsername());
    }

    public Optional<DogHubUser> findPrevious(@NotNull Long id) {
        return repository.findTop1ByIdLessThanOrderByIdDesc(id);
    }

    public Optional<DogHubUser> findNext(@NotNull Long id) {
        return repository.findTop1ByIdGreaterThanOrderById(id);
    }

    public Optional<DogHubUser> findRandom() {
        long count = repository.count();
        Page<DogHubUser> page = repository.findAll(PageRequest.of(RandomUtils.nextInt(0, (int)count), 1, Sort.by(Sort.Direction.ASC, "id")));
        if(page.iterator().hasNext()) {
            return Optional.of(page.iterator().next());
        }
        return Optional.empty();
    }

    public Optional<DogHubUser> findByUsername(@NotNull String username) {
        return repository.findByUsername(username);
    }

    public boolean existsByUsername(@NotNull String username) {
        return repository.existsByUsername(username);
    }
}
